package be.krivi.ucll.da.borecast.core.service;

import be.krivi.ucll.da.borecast.core.exception.DatabaseException;
import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.model.Forecast;
import be.krivi.ucll.da.borecast.core.repository.CityRepository;
import be.krivi.ucll.da.borecast.core.repository.ForecastRepository;
import be.krivi.ucll.da.borecast.core.repository.RepositoryFactory;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * Created by Jan on 28/09/2016.
 */

public class BorecastServiceImpl implements BorecastService{

    private CityRepository cityRepository;
    private ForecastRepository forecastRepository;

    public BorecastServiceImpl( Properties properties ){
        cityRepository = RepositoryFactory.createCityRepository( properties );
        forecastRepository = RepositoryFactory.createForecastRepository( properties );
    }

    public void openConnection(){
        cityRepository.openConnexion();
        forecastRepository.openConnexion();
    }

    public void closeConnection(){
        cityRepository.closeConnexion();
        forecastRepository.closeConnexion();
    }

    //****************************************************************
    // region City
    //****************************************************************

    public City getCityById( Integer id ) throws DatabaseException{
        return cityRepository.getById( id );
    }

    public City getCityByName( String name ) throws DatabaseException{
        return cityRepository.getByName( name );
    }

    public Collection<City> getAllCitys() throws DatabaseException{
        return cityRepository.getAll();
    }

    public void addCity( City city ) throws DatabaseException{
        cityRepository.add( city );
    }

    public void deleteCity( City city ) throws DatabaseException{
        cityRepository.delete( city );
    }

    public void updateCity( City city ) throws DatabaseException{
        cityRepository.update( city );
    }

    //****************************************************************
    // endregion
    //****************************************************************

    //****************************************************************
    // region City
    //****************************************************************

    public Forecast getForecastById( Integer id ) throws DatabaseException{
        return forecastRepository.getById( id );
    }

    public List<Forecast> getByCity( City city ) throws DatabaseException{
        return forecastRepository.getByCity( city );
    }

    public Collection<Forecast> getAllForecast() throws DatabaseException{
        return forecastRepository.getAll();
    }

    public void addForecast( Forecast forecast ) throws DatabaseException{
        forecastRepository.add( forecast );
    }

    public void deleteForecast( Forecast forecast ) throws DatabaseException{
        forecastRepository.delete( forecast );
    }

    public void updateForecast( Forecast forecast ) throws DatabaseException{
        forecastRepository.update( forecast );
    }

    //****************************************************************
    // endregion
    //****************************************************************
}
