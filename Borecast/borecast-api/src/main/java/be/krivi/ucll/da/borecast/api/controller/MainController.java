package be.krivi.ucll.da.borecast.api.controller;

import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.model.Forecast;
import be.krivi.ucll.da.borecast.core.service.BorecastService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by Jan on 12/10/2016.
 */

@Stateless
@Path( "/api" )
public class MainController{

    @Inject
    private BorecastService borecastService;

    @GET
    @Path( "/forecast/{count}" )
    @Produces( "application/json" )
    public List<Forecast> getRoot( @PathParam( "count" ) int count,
                                   @QueryParam( "country" ) String country,
                                   @QueryParam( "city" ) String name ) throws Exception{
        City city = new City();
        city.setName( name );
        city.setCountry( country );

        if(count <= 0 || count > 7)
            count = 7;

        return borecastService.getForecastByCity( city, count );
    }

    @GET
    @Path( "/cities" )
    @Produces( "application/json" )
    public Collection<City> getCities(){
        return borecastService.getAllCitys();
    }
}
