package be.krivi.ucll.da.raspcast.model.service;

import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.core.Temperature;

import java.time.LocalDateTime;

/**
 * Created by Krivi on 16/11/2016.
 */
public class RaspServiceImpl implements RaspService{

    //****************************************************************
    // region Humidity
    //****************************************************************

    @Override
    public void addHumidity( double data ){

    }

    @Override
    public Humidity getHumidity( int offset, int limit ){
        return null;
    }

    @Override
    public Humidity getHumidityByDateTime( LocalDateTime dateTime ){
        return null;
    }

    //****************************************************************
    // endregion
    //****************************************************************

    //****************************************************************
    // region Temperature
    //****************************************************************

    @Override
    public void addTemperature( double data ){

    }

    @Override
    public Temperature getTemperature( int offset, int limit ){
        return null;
    }

    @Override
    public Temperature getTemperatureByDateTime( LocalDateTime dateTime ){
        return null;
    }

    //****************************************************************
    // endregion
    //****************************************************************
}
