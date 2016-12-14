package be.krivi.ucll.da.raspcast.api.controller;

import be.krivi.ucll.da.raspcast.api.dto.UserData;
import be.krivi.ucll.da.raspcast.api.util.KeyGenerator;
import be.krivi.ucll.da.raspcast.model.core.User;
import be.krivi.ucll.da.raspcast.model.service.RaspService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Path( "/auth" )
@Produces( APPLICATION_JSON )
@Consumes( APPLICATION_JSON )
@Transactional
public class UserController{

    @Context
    private UriInfo uriInfo;

    @EJB
    private RaspService service;

    @EJB
    private KeyGenerator keyGenerator;

    @POST
    @Path( "/login" )
    @Consumes( "application/json" )
    @Produces( "plain/text" )
    public Response login( UserData userData ){

        User user = service.getUserByUserName( userData.getUsername() );

        if( user == null || user.isPasswordValid( userData.getPassword() ) )
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
        String jwtToken = Jwts.builder()
                .setSubject( login )
                .setIssuer( uriInfo.getAbsolutePath().toString() )
                .setIssuedAt( new Date() )
                .setExpiration( toDate( LocalDateTime.now().plusMinutes( 15L ) ) )
                .signWith( SignatureAlgorithm.HS512, key )
                .compact();
        return jwtToken;

    }

    private Date toDate( LocalDateTime localDateTime ){
        return Date.from( localDateTime.atZone( ZoneId.systemDefault() ).toInstant() );
    }

    @POST
    @Path( "/add" )
    @Consumes("application/json")
    @Produces("plain/text")
    public void addUser(UserData userData) {
       service.addUser( userData.getUsername(), userData.getPassword() );
    }
}
