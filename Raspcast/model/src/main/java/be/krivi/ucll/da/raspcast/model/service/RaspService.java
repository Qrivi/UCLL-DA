package be.krivi.ucll.da.raspcast.model.service;

import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.core.Temperature;

import java.time.LocalDateTime;

/**
 * Created by Krivi on 16/11/2016.
 */

public interface RaspService{

    //****************************************************************
    // region Humidity
    //****************************************************************

    void addHumidity( double data );

    Humidity getHumidity( int offset, int limit );

    Humidity getHumidityByDateTime( LocalDateTime dateTime );

    //****************************************************************
    // endregion
    //****************************************************************

    //****************************************************************
    // region Temperature
    //****************************************************************

    void addTemperature( double data );

    Temperature getTemperature( int offset, int limit );

    Temperature getTemperatureByDateTime( LocalDateTime dateTime );

    //****************************************************************
    // endregion
    //****************************************************************
}
