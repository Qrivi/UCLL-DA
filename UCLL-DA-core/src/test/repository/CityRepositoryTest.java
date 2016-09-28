package repository;

import be.krivi.ucll.da.borecast.core.entity.City;
import be.krivi.ucll.da.borecast.core.service.Facade;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jan on 28/09/2016.
 */

public class CityRepositoryTest{

    Facade facade;
    City cityLeuven;
    City cityGenk;

    @Before
    public void setUp() throws Exception{
        facade = new Facade();

        cityLeuven = new City();
        cityLeuven.setName( "Leuven" );
        cityLeuven.setCountry( "Belgie" );

        cityGenk = new City();
        cityGenk.setName( "Genk" );
        cityGenk.setCountry( "Belgie" );
    }

    @Test
    public void testGetCitiesAddCity() throws Exception{
        facade.addCity( cityLeuven );
        facade.addCity( cityGenk );

        assertEquals( 2, facade.getCities().size());
    }


    @Test
    public void testGetCity() throws Exception{
        facade.addCity( cityLeuven );

        assertEquals( "Leuven", facade.getCity( cityLeuven.getName() ).getName() );
    }

    @Test
    public void testDeleteCity() throws Exception{
        facade.addCity( cityLeuven );
        facade.deleteCity( cityLeuven.getName() );

        assertEquals( 0, facade.getCities().size());
    }
}