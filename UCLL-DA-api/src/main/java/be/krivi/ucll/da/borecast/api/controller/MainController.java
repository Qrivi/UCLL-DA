package be.krivi.ucll.da.borecast.api.controller;

import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.model.Forecast;
import be.krivi.ucll.da.borecast.core.service.BorecastService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Collection;
import java.util.List;

/**
 * Created by Jan on 12/10/2016.
 */

@Path( "/api" )
public class MainController{

    @Inject
    private BorecastService borecastService;

    @GET
    @Path( "/forecast/{count}/{country}/{city}" )
    @Produces( "application/json")
    public List<Forecast> getRoot( @PathParam( "city" ) String name,
                                   @PathParam( "country" ) String country,
                                   @PathParam( "count" ) String count ) throws Exception{
        City city = new City();
        city.setName( name );
        city.setCountry( country );
        return borecastService.getForecastByCity( city );
    }


    @GET
    @Path( "/cities" )
    @Produces( "application/json")
    public Collection<City> getCities() {
        return borecastService.getAllCitys();
    }

}
