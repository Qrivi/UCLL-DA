package be.krivi.ucll.da.raspcast.parser.controller;

import be.krivi.ucll.da.raspcast.parser.dto.WeatherData;
import be.krivi.ucll.da.raspcast.parser.reader.Reader;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Jan on 17/11/2016.
 */

@Path( "/weather" )
public class Controller{

    @Inject
    private Reader reader;

    @Path( "/" )
    @Produces("application/json")
    public WeatherData getWeather() {
        return reader.read();
    }
}
