package be.krivi.ucll.da.raspcast.api.controller;

import be.krivi.ucll.da.raspcast.api.config.Config;
import be.krivi.ucll.da.raspcast.api.dto.UserData;
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

@Path( "/api" )
public class Controller{

    @EJB
    private RaspService service;

    private DateTimeFormatter simpleDate = DateTimeFormatter.ofPattern( "yyyy-MM-dd" ),
            extendedDate = DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS" );

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
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces( "application/json" )
    public List<Humidity> getHumidity( UserData userData ){

        if( userData.getDate() != null )
            return service.getHumidityByDate( LocalDate.parse( userData.getDate(), simpleDate ) );
        if( userData.getBeforeDate() != null && userData.getAfterDate() != null )
            return service.getHumidityBetweenDates( LocalDate.parse( userData.getBeforeDate(), simpleDate ), LocalDate.parse( userData.getAfterDate(), simpleDate ) );
        if( userData.getBeforeDate() != null )
            return service.getHumidityBeforeDate( LocalDate.parse( userData.getBeforeDate(), simpleDate ) );
        if( userData.getAfterDate() != null )
            return service.getHumidityBeforeDate( LocalDate.parse( userData.getAfterDate(), simpleDate ) );

        return Collections.emptyList();
    }

    @DELETE
    @Path( "/humidity" )
    @Consumes( MediaType.APPLICATION_JSON )
    public void removeHumidity( UserData userData ){
        service.removeHumidityByDateTime( LocalDateTime.parse( userData.getDate(), extendedDate ) );
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

        if( userData.getDate() != null )
            return service.getTemperatureByDate( LocalDate.parse( userData.getDate(), simpleDate ) );
        if( userData.getBeforeDate() != null && userData.getAfterDate() != null )
            return service.getTemperatureBetweenDates( LocalDate.parse( userData.getBeforeDate(), simpleDate ), LocalDate.parse( userData.getAfterDate(), simpleDate ) );
        if( userData.getBeforeDate() != null )
            return service.getTemperatureBeforeDate( LocalDate.parse( userData.getBeforeDate(), simpleDate ) );
        if( userData.getAfterDate() != null )
            return service.getTemperatureAfterDate( LocalDate.parse( userData.getAfterDate(), simpleDate ) );

        return Collections.emptyList();
    }

    @DELETE
    @Path( "/temperature" )
    @Consumes( MediaType.APPLICATION_JSON )
    public void removeTemperature( UserData userData ){
        service.removeTemperatureByDateTime( LocalDateTime.parse( userData.getDate(), extendedDate ) );
    }

    //****************************************************************
    // region endregion
    //****************************************************************
}
