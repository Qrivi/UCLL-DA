package be.krivi.ucll.da.borecast.api.controller;

import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.model.Forecast;
import be.krivi.ucll.da.borecast.core.service.BorecastService;
import be.krivi.ucll.da.borecast.core.service.BorecastServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by Jan on 12/10/2016.
 */

@Path( "/api" )
public class MainController{


    private BorecastService borecastService = new BorecastServiceImpl();



    @GET
    public List<Forecast> getRoot() throws Exception{
        City genk = new City();
        genk.setName( "Genk" );
        genk.setCountry( "BE" );
        genk.setLat( 50.965 );
        genk.setLon( 5.50082 );

        return borecastService.getForecastByCity( genk );
    }


}
