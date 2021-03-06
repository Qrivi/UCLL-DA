package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.exception.DatabaseException;
import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.model.Forecast;
import be.krivi.ucll.da.borecast.core.repository.map.CRUDMapDB;

import java.util.LinkedList;
import java.util.List;

public class ForecastMap extends CRUDMapDB<Forecast> implements ForecastRepository{

    public ForecastMap(){
        super();
        //addTestData();
    }

    @Override
    public List<Forecast> getByCity( City city ) throws DatabaseException{
        List<Forecast> list = new LinkedList<>();
        for( Forecast f : map.values() ){
            if( f.getCity().equals( city ) ){
                list.add( f );
            }
        }
        return list;
        // return map.values().stream().filter( ( n ) -> n.getCity().equals( city ) ).collect( Collectors.toList() );
    }

   /* private void addTestData(){

        City z = new City();
        z.setName( "Beijing" );
        z.setCountry( "CN" );
        z.setLat( 39.907501 );
        z.setLon( 116.397232 );

        LocalDateTime y = LocalDateTime.now();
        LocalDateTime x = y.plus( 1, ChronoUnit.DAYS );
        LocalDateTime w = x.plus( 1, ChronoUnit.DAYS );
        LocalDateTime v = w.plus( 1, ChronoUnit.DAYS );
        LocalDateTime u = v.plus( 1, ChronoUnit.DAYS );
        LocalDateTime t = u.plus( 1, ChronoUnit.DAYS );
        LocalDateTime s = t.plus( 1, ChronoUnit.DAYS );

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
    }*/
}
