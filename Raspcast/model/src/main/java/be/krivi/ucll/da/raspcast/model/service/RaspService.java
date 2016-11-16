package be.krivi.ucll.da.raspcast.model.service;

import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.core.Temperature;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Krivi on 16/11/2016.
 */

public interface RaspService{

    //****************************************************************
    // region Humidity
    //****************************************************************

    void addHumidity( double data );

    List<Humidity> getHumidity();

    List<Humidity> getHumidity( int offset, int limit );

    List<Humidity> getHumidityByDateTime( LocalDate dateTime );

    List<Humidity> getHumidityBeforeDateTime( LocalDate dateTime );

    List<Humidity> getHumidityAfterDateTime( LocalDate dateTime );

    List<Humidity> getHumidityBetweenDateTime( LocalDate after, LocalDate before );

    //****************************************************************
    // endregion
    //****************************************************************

    //****************************************************************
    // region Temperature
    //****************************************************************

    void addTemperature( double data );

    List<Temperature> getTemperature();

    List<Temperature> getTemperature( int offset, int limit );

    List<Temperature> getTemperatureByDateTime( LocalDate dateTime );

    List<Temperature> getTemperatureBeforeDateTime( LocalDate dateTime );

    List<Temperature> getTemperatureAfterDateTime( LocalDate dateTime );

    List<Temperature> getTemperatureBetweenDateTime( LocalDate after, LocalDate before );

    //****************************************************************
    // endregion
    //****************************************************************
}
