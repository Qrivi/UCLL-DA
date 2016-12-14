package be.krivi.ucll.da.raspcast.api.filter;

import be.krivi.ucll.da.raspcast.api.util.KeyGenerator;
import io.jsonwebtoken.Jwts;

import javax.annotation.Priority;
import javax.ejb.EJB;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Key;

@Provider
@JWTSecured
@Priority( Priorities.AUTHENTICATION )
public class JWTSecuredFilter implements ContainerRequestFilter{

    @EJB
    private KeyGenerator keyGenerator;

    @Override
    public void filter( ContainerRequestContext requestContext ) throws IOException{

        try{
            String authorizationHeader = requestContext.getHeaderString( HttpHeaders.AUTHORIZATION );
            String token = authorizationHeader.substring( "Bearer".length() ).trim();

            Key key = keyGenerator.generateKey();
            Jwts.parser().setSigningKey( key ).parseClaimsJws( token );

        }catch( Exception e ){
            requestContext.abortWith(
                    Response.status( Response.Status.UNAUTHORIZED )
                            .entity( "HTTP 401 Unauthorized" )
                            .build() );
        }
    }
}