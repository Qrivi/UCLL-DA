package be.krivi.ucll.da.raspcast.api.controller;

import be.krivi.ucll.da.raspcast.api.config.Config;
import be.krivi.ucll.da.raspcast.api.dto.UserData;
import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.core.Temperature;
import be.krivi.ucll.da.raspcast.model.service.RaspService;
import be.krivi.ucll.da.raspcast.parser.dto.WeatherData;
import be.krivi.ucll.da.raspcast.parser.reader.Reader;
import be.krivi.ucll.da.raspcast.parser.reader.ReaderFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jan on 16/11/2016.
 */

@Path( "/api" )
public class Controller{

    @Inject
    private RaspService service;

    @GET
    @Path( "/fetch" )
    @Produces( "application/json" )
    public String fetchData( @QueryParam( "data" ) String data ){
        try{
            Reader reader = ReaderFactory.getReader( Config.READER );
            WeatherData weather = reader.read();

            if( !"t".equals( data ) )
                service.addHumidity( weather.getHumidity() );
            if( !"h".equals( data ) )
                service.addTemperature( weather.getTemperature() );

            return "Data was added (" + weather + ")";
        }catch( Exception e ){
            return "Beep beep bong, something went wrong";
        }
    }

    //****************************************************************
    // region Humidity
    //****************************************************************

    @GET
    @Path( "/humidity" )
    @Produces( "application/json" )
    public List<Humidity> getHumidity( @QueryParam( "limit" ) @DefaultValue( "-1" ) int limit,
                                       @QueryParam( "offset" ) @DefaultValue( "-1" ) int offset ){

        if( limit == -1 && offset == -1 )
            return service.getHumidity();

        if( limit == -1 )
            limit = Config.DEFAULT_LIMIT;
        if( offset == -1 )
            offset = Config.DEFAULT_OFFSET;

        return service.getHumidity( limit, offset );
    }

    @POST
    @Path( "/humidity" )
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces( "application/json" )
    public List<Humidity> getHumidity( UserData userData ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

        if( userData.getDate() != null )
            return service.getHumidityByDate( LocalDate.parse( userData.getDate(), formatter ) );
        if( userData.getBeforeDate() != null && userData.getAfterDate() != null )
            return service.getHumidityBetweenDates( LocalDate.parse( userData.getBeforeDate(), formatter )
                    , LocalDate.parse( userData.getAfterDate(), formatter ) );
        if( userData.getBeforeDate() != null )
            return service.getHumidityBeforeDate( LocalDate.parse( userData.getBeforeDate(), formatter ) );
        if( userData.getAfterDate() != null )
            return service.getHumidityBeforeDate( LocalDate.parse( userData.getAfterDate(), formatter ) );

        return Collections.emptyList();
    }

    @DELETE
    @Path( "/humidity" )
    @Consumes( MediaType.APPLICATION_JSON )
    public void removeHumidity( UserData userData ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS" );
        service.removeHumidityByDateTime( LocalDateTime.parse( userData.getDate(), formatter ) );
    }

    //****************************************************************
    // region endregion
    //****************************************************************

    //****************************************************************
    // region Temperature
    //****************************************************************

    @GET
    @Path( "/temperature" )
    @Produces( "application/json" )
    public List<Temperature> getTemperature( @QueryParam( "limit" ) @DefaultValue( "-1" ) int limit,
                                             @QueryParam( "offset" ) @DefaultValue( "-1" ) int offset ){
        if( limit == -1 && offset == -1 )
            return service.getTemperature();

        if( limit == -1 )
            limit = Config.DEFAULT_LIMIT;
        if( offset == -1 )
            offset = Config.DEFAULT_OFFSET;

        return service.getTemperature( limit, offset );
    }

    @POST
    @Path( "/temperature" )
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces( "application/json" )
    public List<Temperature> getTemperature( UserData userData ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

        if( userData.getDate() != null )
            return service.getTemperatureByDate( LocalDate.parse( userData.getDate(), formatter ) );
        if( userData.getBeforeDate() != null && userData.getAfterDate() != null )
            return service.getTemperatureBetweenDates( LocalDate.parse( userData.getBeforeDate(), formatter )
                    , LocalDate.parse( userData.getAfterDate(), formatter ) );
        if( userData.getBeforeDate() != null )
            return service.getTemperatureBeforeDate( LocalDate.parse( userData.getBeforeDate(), formatter ) );
        if( userData.getAfterDate() != null )
            return service.getTemperatureAfterDate( LocalDate.parse( userData.getAfterDate(), formatter ) );

        return Collections.emptyList();
    }

    @DELETE
    @Path( "/temperature" )
    @Consumes( MediaType.APPLICATION_JSON )
    public void removeTemperature( UserData userData ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS" );
        service.removeTemperatureByDateTime( LocalDateTime.parse( userData.getDate(), formatter ) );
    }

    //****************************************************************
    // region endregion
    //****************************************************************
}
