package be.krivi.ucll.da.raspcast.model.service;

import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.core.Temperature;
import be.krivi.ucll.da.raspcast.model.core.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RaspService{

    //****************************************************************
    // region Humidity
    //****************************************************************

    void addHumidity( double data );

    List<Humidity> getHumidity();

    List<Humidity> getHumidity( int offset, int limit );

    Humidity getHumidityByDateTime( LocalDateTime date );

    void removeHumidityByDateTime( LocalDateTime date );

    List<Humidity> getHumidityByDate( LocalDate date );

    List<Humidity> getHumidityBeforeDate( LocalDate date );

    List<Humidity> getHumidityAfterDate( LocalDate date );

    List<Humidity> getHumidityBetweenDates( LocalDate after, LocalDate before );

    //****************************************************************
    // endregion
    //****************************************************************

    //****************************************************************
    // region Temperature
    //****************************************************************

    void addTemperature( double data );

    List<Temperature> getTemperature();

    List<Temperature> getTemperature( int offset, int limit );

    Temperature getTemperatureByDateTime( LocalDateTime date );

    void removeTemperatureByDateTime( LocalDateTime date );

    List<Temperature> getTemperatureByDate( LocalDate date );

    List<Temperature> getTemperatureBeforeDate( LocalDate date );

    List<Temperature> getTemperatureAfterDate( LocalDate date );

    List<Temperature> getTemperatureBetweenDates( LocalDate after, LocalDate before );

    //****************************************************************
    // endregion
    //****************************************************************

    //****************************************************************
    // region User
    //****************************************************************

    void addUser( String userName, String plainPassword );

    User getUserByUserName( String userName );

    void updateUser( User user );

    void removeUser( User user );

    //****************************************************************
    // endregion
    //****************************************************************
}
