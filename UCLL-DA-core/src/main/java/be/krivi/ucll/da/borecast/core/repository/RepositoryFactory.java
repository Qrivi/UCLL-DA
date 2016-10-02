package be.krivi.ucll.da.borecast.core.repository;

import java.util.Properties;

public class RepositoryFactory{

    public static CityRepository createCityRepository( Properties properties ){

        String type = properties.getProperty( "type" );
        String name = properties.getProperty( "name" );

        if( "MAP".equals( type ) )
            return new CityMap();
        if( "DB".equals( type ) )
            return new CityRDB( name );
        return null;
    }
}
