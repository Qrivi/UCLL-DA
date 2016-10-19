package be.krivi.ucll.da.borecast.core.service;

import be.krivi.ucll.da.borecast.core.exception.DatabaseException;
import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.model.Forecast;

import java.util.Collection;
import java.util.List;

/**
 * Created by Krivi on 6/10/2016.
 */

public interface BorecastService{

    void openConnection();

    void closeConnection();

    //****************************************************************
    // region City
    //****************************************************************

    City getCityById( Integer id ) throws DatabaseException;

    City getCityByName( String city, String country ) throws DatabaseException;

    Collection<City> getAllCitys() throws DatabaseException;

    void addCity( City city ) throws DatabaseException;

    void deleteCity( City city ) throws DatabaseException;

    void updateCity( City city ) throws DatabaseException;

    //****************************************************************
    // endregion
    //****************************************************************

    //****************************************************************
    // region City
    //****************************************************************

    Forecast getForecastById( Integer id ) throws DatabaseException;

    List<Forecast> getForecastByCity( City city, int index ) throws DatabaseException;

    Collection<Forecast> getAllForecasts() throws DatabaseException;

    void addForecast( Forecast forecast ) throws DatabaseException;

    void deleteForecast( Forecast forecast ) throws DatabaseException;

    void updateForecast( Forecast forecast ) throws DatabaseException;

    //****************************************************************
    // endregion
    //****************************************************************
}
