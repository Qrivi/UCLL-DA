package be.krivi.ucll.da.borecast.core.service;

import be.krivi.ucll.da.borecast.core.exception.DatabaseException;
import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.repository.CityRepository;
import be.krivi.ucll.da.borecast.core.repository.RepositoryFactory;

import java.util.Collection;
import java.util.Properties;

/**
 * Created by Jan on 28/09/2016.
 */

public class BorecastService{

    private CityRepository cityRepository;

    public BorecastService( Properties properties ){
        cityRepository = RepositoryFactory.createCityRepository( properties );
    }

    public void openConnection(){
        cityRepository.openConnexion();
    }

    public void closeConnection(){
        cityRepository.closeConnexion();
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
}
