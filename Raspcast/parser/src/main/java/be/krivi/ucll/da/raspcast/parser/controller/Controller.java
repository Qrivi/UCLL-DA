package be.krivi.ucll.da.raspcast.parser.controller;

import be.krivi.ucll.da.raspcast.parser.dto.WeatherData;
import be.krivi.ucll.da.raspcast.parser.exception.ReadException;
import be.krivi.ucll.da.raspcast.parser.filter.BasicAuthSecured;
import be.krivi.ucll.da.raspcast.parser.reader.Reader;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Basic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@BasicAuthSecured
@Stateless
@Path( "/weather" )
public class Controller{

    @EJB
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
