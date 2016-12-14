package be.krivi.ucll.da.raspcast.api.controller;

import be.krivi.ucll.da.raspcast.api.dto.UserData;
import be.krivi.ucll.da.raspcast.api.util.KeyGenerator;
import be.krivi.ucll.da.raspcast.model.core.User;
import be.krivi.ucll.da.raspcast.model.exception.DatabaseException;
import be.krivi.ucll.da.raspcast.model.service.RaspService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.exception.ExceptionUtils;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Path( "/auth" )
public class UserController{

    @EJB
    private RaspService service;

    @EJB
    private KeyGenerator keyGenerator;

    @Context
    private UriInfo uriInfo;

    @POST
    @Path( "/login" )
    @Consumes( "application/json" )
    @Produces( "plain/text" )
    public Response login( UserData userData ){

        User user = service.getUserByUserName( userData.getUsername() );

        if( user == null || !user.isPasswordValid( userData.getPassword() ) )
            return Response.status( UNAUTHORIZED )
                    .entity( "HTTP 401 Unauthorized" )
                    .build();

        String token = issueToken( userData.getUsername() );
        return Response.ok()
                .header( AUTHORIZATION, "Bearer " + token )
                .entity( "HTTP 200 OK" )
                .build();
    }

    private String issueToken( String login ){
        Key key = keyGenerator.generateKey();
        Calendar exp = Calendar.getInstance();

        exp.add( Calendar.HOUR, 8 );

        String jwtToken = Jwts.builder()
                .setSubject( login )
                .setIssuer( uriInfo.getAbsolutePath().toString() )
                .setIssuedAt( new Date() )
                .setExpiration( exp.getTime() )
                .signWith( SignatureAlgorithm.HS512, key )
                .compact();
        return jwtToken;
    }

    @POST
    @Path( "/new" )
    @Consumes( "application/json" )
    @Produces( "plain/text" )
    public Response createUser( UserData userData ){

        try{
            service.addUser( userData.getUsername(), userData.getPassword() );

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
}
