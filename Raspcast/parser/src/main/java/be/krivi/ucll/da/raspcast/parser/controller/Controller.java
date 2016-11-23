package be.krivi.ucll.da.raspcast.parser.controller;

import be.krivi.ucll.da.raspcast.parser.dto.WeatherData;
import be.krivi.ucll.da.raspcast.parser.exception.ReadException;
import be.krivi.ucll.da.raspcast.parser.reader.Reader;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Jan on 17/11/2016.
 */

@Stateless
@Path( "/weather" )
public class Controller{

    @Inject
    private Reader reader;

    @GET
    @Path( "/" )
    @Produces( "application/json" )
    public WeatherData getWeather(){
        try{
            return reader.read();
        }catch( ReadException e ){
            return null;
        }
    }
}
