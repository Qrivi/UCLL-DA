package be.krivi.ucll.da.raspcast.model.service;

import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.core.Temperature;
import be.krivi.ucll.da.raspcast.model.db.HumidityDB;
import be.krivi.ucll.da.raspcast.model.db.TemperatureDB;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Krivi on 16/11/2016.
 */

public class RaspServiceImpl implements RaspService{

    @Inject
    private HumidityDB humidityDB;

    @Inject
    private TemperatureDB temperatureDB;

    //****************************************************************
    // region Humidity
    //****************************************************************

    @Override
    public void addHumidity( double data ){
        humidityDB.add( new Humidity( data ) );
    }

    @Override
    public List<Humidity> getHumidity(){
        return new LinkedList<>( humidityDB.getAll() );
    }

    @Override
    public List<Humidity> getHumidity( int limit, int offset ){
        List<Humidity> humidityList = new LinkedList<>( humidityDB.getAll() );

        int to = humidityList.size() - 1 - Math.abs( offset );
        int from = to - Math.abs( limit );

        if( to > humidityList.size() - 1 )
            to = humidityList.size() - 1;
        if( from < 0 )
            from = 0;

        return humidityList.subList( from, to );
    }

    @Override
    public List<Humidity> getHumidityByDateTime( LocalDate dateTime ){
        return humidityDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isEqual( dateTime ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Humidity> getHumidityBeforeDateTime( LocalDate dateTime ){
        return humidityDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isBefore( dateTime ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Humidity> getHumidityAfterDateTime( LocalDate dateTime ){
        return humidityDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isAfter( dateTime ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Humidity> getHumidityBetweenDateTime( LocalDate after, LocalDate before ){
        return humidityDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isAfter( after ) )
                .filter( ( n ) -> n.getDateTime().toLocalDate().isBefore( before ) )
                .collect( Collectors.toList() );
    }

    //****************************************************************
    // endregion
    //****************************************************************

    //****************************************************************
    // region Temperature
    //****************************************************************

    @Override
    public void addTemperature( double data ){
        temperatureDB.add( new Temperature( data ) );
    }

    @Override
    public List<Temperature> getTemperature(){
        return new LinkedList<>( temperatureDB.getAll() );
    }

    @Override
    public List<Temperature> getTemperature( int limit, int offset ){
        List<Temperature> temperatureList = new LinkedList<>( temperatureDB.getAll() );

        int to = temperatureList.size() - 1 - Math.abs( offset );
        int from = to - Math.abs( limit );

        if( to > temperatureList.size() - 1 )
            to = temperatureList.size() - 1;
        if( from < 0 )
            from = 0;

        return temperatureList.subList( from, to );
    }

    @Override
    public List<Temperature> getTemperatureByDateTime( LocalDate dateTime ){
        return temperatureDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isEqual( dateTime ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Temperature> getTemperatureBeforeDateTime( LocalDate dateTime ){
        return temperatureDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isBefore( dateTime ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Temperature> getTemperatureAfterDateTime( LocalDate dateTime ){
        return temperatureDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isAfter( dateTime ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Temperature> getTemperatureBetweenDateTime( LocalDate after, LocalDate before ){
        return temperatureDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isAfter( after ) )
                .filter( ( n ) -> n.getDateTime().toLocalDate().isBefore( before ) )
                .collect( Collectors.toList() );
    }

    //****************************************************************
    // endregion
    //****************************************************************
}
