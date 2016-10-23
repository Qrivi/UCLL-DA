package be.krivi.ucll.da.borecast.core.service;

import be.krivi.ucll.da.borecast.consumer.Consumer;
import be.krivi.ucll.da.borecast.core.exception.DatabaseException;
import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.model.Forecast;
import be.krivi.ucll.da.borecast.core.repository.CityRepository;
import be.krivi.ucll.da.borecast.core.repository.ForecastRepository;
import be.krivi.ucll.da.borecast.core.repository.RepositoryFactory;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * Created by Jan on 28/09/2016.
 */

@Stateless
public class BorecastServiceImpl implements BorecastService{

    private static final String DB_CONFIG = "DatabaseConfig.properties";

    @Inject
    private Consumer consumer;
    private CityRepository cityRepository;
    private ForecastRepository forecastRepository;

    public BorecastServiceImpl( Properties properties ){
        //TODO use @inject
        //consumer = new Consumer();
        cityRepository = RepositoryFactory.createCityRepository( properties );
        forecastRepository = RepositoryFactory.createForecastRepository( properties );
    }

    public BorecastServiceImpl(){
        //TODO use @inject
        //consumer = new Consumer();
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        try( InputStream resourceStream = loader.getResourceAsStream( DB_CONFIG ) ){
            properties.load( resourceStream );

            cityRepository = RepositoryFactory.createCityRepository( properties );
            forecastRepository = RepositoryFactory.createForecastRepository( properties );
        }catch( IOException e ){
            //RIP
        }
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

    public City getCityByName( String city, String country ) throws DatabaseException{
        return cityRepository.getByName( city, country );
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

    public List<Forecast> getForecastByCity( City city, int limit ) throws DatabaseException{
        limit = limit <= 0 ? 6 : limit - 1;
        List<Forecast> forecastList = forecastRepository.getByCity( city );

        if( forecastList.isEmpty() ){
            forecastList = consumer.fetchForecastForCity( city );
            addForecastList( forecastList );
            if( city.equals( forecastList.get( 0 ).getCity() ) )
                addCity( forecastList.get( 0 ).getCity() );
            forecastList = forecastRepository.getByCity( city );
            return forecastList.isEmpty() ? forecastList : forecastList.subList( forecastList.size() - limit, limit );
        }else if( !forecastList.get( forecastList.size() - 1 ).getDate().toLocalDate().equals( LocalDate.now().plusDays( 6 )) ){
            for( Forecast f : consumer.fetchForecastForCity( city ) )
                if( forecastRepository.getById( f.getId() ) == null )
                    addForecast( f );
                else
                    updateForecast( f );
            forecastList = forecastRepository.getByCity( city );
            return forecastList.subList( forecastList.size() - limit, limit );
        }
        return forecastList.subList( forecastList.size() - limit, limit );
    }

    public Collection<Forecast> getAllForecasts() throws DatabaseException{
        return forecastRepository.getAll();
    }

    public void addForecast( Forecast forecast ) throws DatabaseException{
        forecastRepository.add( forecast );
    }

    public void addForecastList( List<Forecast> forecastList ){
        for( Forecast f : forecastList )
            addForecast( f );
    }

    public void deleteForecast( Forecast forecast ) throws DatabaseException{
        forecastRepository.delete( forecast );
    }

    public void updateForecast( Forecast forecast ) throws DatabaseException{
        forecastRepository.update( forecast );
    }

    @Schedule( minute = "30", persistent = false )
    public void updateAllForecasts(){
        for( City c : getAllCitys() )
            getForecastByCity( c, 7 );
    }

    //****************************************************************
    // endregion
    //****************************************************************
}
