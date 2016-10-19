package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.exception.DatabaseException;
import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.repository.map.CRUDMapDB;

public class CityMap extends CRUDMapDB<City> implements CityRepository{

    public CityMap(){
        super();
        //addTestData();
    }

    @Override
    public City getByName( String city, String country ) throws DatabaseException{
        return map.values()
                .stream()
                .filter( ( n ) -> n.getName().equals( city ) )
                .filter( ( n ) -> n.getCountry().equals( country ) )
                .findFirst()
                .get();
    }

  /*  private void addTestData(){

        City a = new City();
        a.setName( "Leuven" );
        a.setCountry( "BE" );
        a.setLat( 50.877049 );
        a.setLon( 4.698219 );

        City b = new City();
        b.setName( "Paris" );
        b.setCountry( "FR" );
        b.setLat( 48.860871 );
        b.setLon( 2.346526 );

        City c = new City();
        c.setName( "New York" );
        c.setCountry( "US" );
        c.setLat( 40.725863 );
        c.setLon( -73.999296 );

        City d = new City();
        d.setName( "Beijing" );
        d.setCountry( "CN" );
        d.setLat( 39.937494 );
        d.setLon( 116.394686 );

        map.put( 0, a );
        map.put( 1, b );
        map.put( 2, c );
        map.put( 3, d );
    }*/
}
