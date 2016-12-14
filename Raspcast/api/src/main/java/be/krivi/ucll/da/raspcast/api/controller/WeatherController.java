package be.krivi.ucll.da.raspcast.api.controller;

import be.krivi.ucll.da.raspcast.api.config.Config;
import be.krivi.ucll.da.raspcast.api.dto.WeatherData;
import be.krivi.ucll.da.raspcast.api.filter.JWTSecured;
import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.core.Temperature;
import be.krivi.ucll.da.raspcast.model.exception.DatabaseException;
import be.krivi.ucll.da.raspcast.model.service.RaspService;
import org.apache.commons.lang.exception.ExceptionUtils;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@JWTSecured
@Path( "/api" )
public class WeatherController{

    @EJB
    private RaspService service;

    private DateTimeFormatter simpleDate = DateTimeFormatter.ofPattern( "yyyy-MM-dd" ),
            extendedDate = DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss" );

    @GET
    @Path( "/fetch" )
    @Produces( "text/plain" )
    public Response fetchData( @QueryParam( "data" ) String data ){

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target( Config.DATA_URL );
        JsonObject o = target.request( MediaType.APPLICATION_JSON_TYPE ).get( JsonObject.class );

        try{
            if( !"t".equals( data ) )
                service.addHumidity( Double.parseDouble( o.get( "humidity" ).toString() ) );
            if( !"h".equals( data ) )
                service.addTemperature( Double.parseDouble( o.get( "temperature" ).toString() ) );
        }catch( Exception e ){
            if( ExceptionUtils.indexOfThrowable( e, DatabaseException.class ) != -1 )
                return Response.status( Response.Status.CONFLICT )
                        .entity( "HTTP 409 Conflict" )
                        .build();
            return Response.status( Response.Status.INTERNAL_SERVER_ERROR )
                    .entity( "HTTP 500 Internal Server Error" )
                    .build();
        }
        return Response.status( Response.Status.CREATED )
                .entity( "HTTP 201 Created" )
                .build();
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
    @Consumes( "application/json" )
    @Produces( "application/json" )
    public List<Humidity> getHumidity( WeatherData weatherData ){

        // TODO check ifs in multiple scenarios

        if( weatherData.getDate() != null )
            return service.getHumidityByDate( LocalDate.parse( weatherData.getDate(), simpleDate ) );
        if( weatherData.getBeforeDate() != null && weatherData.getAfterDate() != null )
            return service.getHumidityBetweenDates( LocalDate.parse( weatherData.getBeforeDate(), simpleDate ), LocalDate.parse( weatherData.getAfterDate(), simpleDate ) );
        if( weatherData.getBeforeDate() != null )
            return service.getHumidityBeforeDate( LocalDate.parse( weatherData.getBeforeDate(), simpleDate ) );
        if( weatherData.getAfterDate() != null )
            return service.getHumidityBeforeDate( LocalDate.parse( weatherData.getAfterDate(), simpleDate ) );

        return Collections.emptyList();
    }

    @DELETE //TODO does not seem to work with delete method
    @Path( "/humidity" )
    @Consumes( "application/json" )
    public void removeHumidity( WeatherData weatherData ){
        service.removeHumidityByDateTime( LocalDateTime.parse( weatherData.getDate(), extendedDate ) );
    }

    // TODO delete by id

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
    @Consumes( "application/json" )
    @Produces( "application/json" )
    public List<Temperature> getTemperature( WeatherData weatherData ){

        if( weatherData.getDate() != null )
            return service.getTemperatureByDate( LocalDate.parse( weatherData.getDate(), simpleDate ) );
        if( weatherData.getBeforeDate() != null && weatherData.getAfterDate() != null )
            return service.getTemperatureBetweenDates( LocalDate.parse( weatherData.getBeforeDate(), simpleDate ), LocalDate.parse( weatherData.getAfterDate(), simpleDate ) );
        if( weatherData.getBeforeDate() != null )
            return service.getTemperatureBeforeDate( LocalDate.parse( weatherData.getBeforeDate(), simpleDate ) );
        if( weatherData.getAfterDate() != null )
            return service.getTemperatureAfterDate( LocalDate.parse( weatherData.getAfterDate(), simpleDate ) );

        return Collections.emptyList();
    }

    @DELETE //TODO does not seem to work with delete method
    @Path( "/temperature" )
    @Consumes( "application/json" )
    public void removeTemperature( WeatherData weatherData ){
        service.removeTemperatureByDateTime( LocalDateTime.parse( weatherData.getDate(), extendedDate ) );
    }

    // TODO delete by id

    //****************************************************************
    // region endregion
    //****************************************************************
}
