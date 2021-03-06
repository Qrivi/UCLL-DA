package be.krivi.ucll.da.raspcast.model.service;

import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.core.Temperature;
import be.krivi.ucll.da.raspcast.model.core.User;
import be.krivi.ucll.da.raspcast.model.db.HumidityDB;
import be.krivi.ucll.da.raspcast.model.db.TemperatureDB;
import be.krivi.ucll.da.raspcast.model.db.UserDB;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class RaspServiceImpl implements RaspService{

    @Inject
    private HumidityDB humidityDB;

    @Inject
    private TemperatureDB temperatureDB;

    @Inject
    private UserDB userDB;

    //****************************************************************
    // region Humidity
    //****************************************************************

    @Override
    public void addHumidity( double data ){
        humidityDB.add( new Humidity( data ) );
    }

    @Override
    public Humidity getHumidityById( int id ){
        return humidityDB.getById( id );
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
    public Humidity getHumidityByDateTime( LocalDateTime dateTime ){
        return humidityDB.getByDateTime( dateTime );
    }

    @Override
    public void removeHumidityByDateTime( LocalDateTime dateTime ){
        humidityDB.delete( humidityDB.getByDateTime( dateTime ) );
    }

    @Override
    public void removeHumidityById( Integer id ){
        humidityDB.delete( humidityDB.getById( id ) );
    }

    @Override
    public List<Humidity> getHumidityByDate( LocalDate date ){
        return humidityDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isEqual( date ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Humidity> getHumidityBeforeDate( LocalDate date ){
        return humidityDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isBefore( date ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Humidity> getHumidityAfterDate( LocalDate date ){
        return humidityDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isAfter( date ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Humidity> getHumidityBetweenDates( LocalDate after, LocalDate before ){
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
    public Temperature getTemperatureById( int id ){
        return temperatureDB.getById( id );
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
    public Temperature getTemperatureByDateTime( LocalDateTime dateTime ){
        return temperatureDB.getByDateTime( dateTime );
    }

    @Override
    public void removeTemperatureByDateTime( LocalDateTime dateTime ){
        temperatureDB.delete( temperatureDB.getByDateTime( dateTime ) );
    }

    @Override
    public void removeTemperatureById( Integer id ){
        temperatureDB.delete( temperatureDB.getById( id ) );
    }

    @Override
    public List<Temperature> getTemperatureByDate( LocalDate date ){
        return temperatureDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isEqual( date ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Temperature> getTemperatureBeforeDate( LocalDate date ){
        return temperatureDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isBefore( date ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Temperature> getTemperatureAfterDate( LocalDate date ){
        return temperatureDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isAfter( date ) )
                .collect( Collectors.toList() );
    }

    @Override
    public List<Temperature> getTemperatureBetweenDates( LocalDate after, LocalDate before ){
        return temperatureDB.getAll()
                .stream()
                .filter( ( n ) -> n.getDateTime().toLocalDate().isAfter( after ) )
                .filter( ( n ) -> n.getDateTime().toLocalDate().isBefore( before ) )
                .collect( Collectors.toList() );
    }

    //****************************************************************
    // endregion
    //****************************************************************

    //****************************************************************
    // region User
    //****************************************************************

    @Override
    public void addUser( String userName, String plainPassword ){
        userDB.add( new User( userName, plainPassword ) );
    }

    @Override
    public User getUserByUserName( String userName ){
        return userDB.getByUserName( userName );
    }

    @Override
    public void updateUser( User user ){
        userDB.update( user );
    }

    @Override
    public void removeUser( User user ){
        userDB.delete( user );
    }

    //****************************************************************
    // endregion
    //****************************************************************
}
