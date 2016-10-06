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

    public static ConditionRepository createConditionRepository( Properties properties ){

        String type = properties.getProperty( "type" );
        String name = properties.getProperty( "name" );

        if( "MAP".equals( type ) )
            return new ConditionMap();
        if( "DB".equals( type ) )
            return new ConditionRDB( name );
        return null;
    }

    public static ForecastRepository createForecastRepository( Properties properties ){

        String type = properties.getProperty( "type" );
        String name = properties.getProperty( "name" );

        if( "MAP".equals( type ) )
            return new ForecastMap();
        if( "DB".equals( type ) )
            return new ForecastRDB( name );
        return null;
    }

    public static TemperatureRepository createTemperatureRepository( Properties properties ){

        String type = properties.getProperty( "type" );
        String name = properties.getProperty( "name" );

        if( "MAP".equals( type ) )
            return new TemperatureMap();
        if( "DB".equals( type ) )
            return new TemperatureRDB( name );
        return null;
    }

    public static WindRepository createWindRepository( Properties properties ){

        String type = properties.getProperty( "type" );
        String name = properties.getProperty( "name" );

        if( "MAP".equals( type ) )
            return new WindMap();
        if( "DB".equals( type ) )
            return new WindRDB( name );
        return null;
    }
}
