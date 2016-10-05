package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.exception.DatabaseException;
import be.krivi.ucll.da.borecast.core.model.*;
import be.krivi.ucll.da.borecast.core.repository.map.CRUDMapDB;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class ForecastMap extends CRUDMapDB<Forecast> implements ForecastRepository{

    public ForecastMap(){
        super();
        addTestData();
    }

    @Override
    public List<Forecast> getByCity( City city ) throws DatabaseException{
        return map.values().stream().filter( ( n ) -> n.getCity().equals( city ) ).collect( Collectors.toList() );
    }

    @Override
    public List<Forecast> getByCity( String city ) throws DatabaseException{
        //TODO implement
        return null;
    }

    private void addTestData(){

        City z = new City();
        z.setName( "Beijing" );
        z.setCountry( "CN" );
        z.setLat( 39.907501 );
        z.setLon( 116.397232 );

        LocalDate y = LocalDate.now();
        LocalDate x = y.plus( 1, ChronoUnit.DAYS );
        LocalDate w = x.plus( 1, ChronoUnit.DAYS );
        LocalDate v = w.plus( 1, ChronoUnit.DAYS );
        LocalDate u = v.plus( 1, ChronoUnit.DAYS );
        LocalDate t = u.plus( 1, ChronoUnit.DAYS );
        LocalDate s = t.plus( 1, ChronoUnit.DAYS );

        Condition r = new Condition();
        r.setTitle( "Clear" );
        r.setDescription( "Clear sky" );
        r.setIcon( "01d" );
        r.setCloudDensity( 0 );
        r.setRainPossibility( 0 );
        r.setSnowPossibility( 0 );


        Forecast a = new Forecast();
        a.setCity( z );
        a.setDate( y );


        private City city;
        private LocalDate date;
        private Condition condition;
        private Temperature temperature;
        private double humidity;
        private double pressure;
        private Wind wind;
    }
}
