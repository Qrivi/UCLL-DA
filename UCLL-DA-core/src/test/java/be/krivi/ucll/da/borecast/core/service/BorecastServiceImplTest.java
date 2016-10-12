package be.krivi.ucll.da.borecast.core.service;

import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.model.Forecast;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Jan on 28/09/2016.
 */

public class BorecastServiceImplTest{

    BorecastService facade;
    City genk;

    @Before
    public void setUp() throws Exception{
        facade = new BorecastServiceImpl();
        genk = new City();
        genk.setName( "Genk" );
        genk.setCountry( "BE" );
        genk.setLat( 50.965 );
        genk.setLon( 5.50082 );
    }

    @Test
    public void test() throws Exception{
        List<Forecast> forecastList = facade.getForecastByCity( genk );

        for( Forecast f : forecastList )
            System.out.println( f );
    }
}