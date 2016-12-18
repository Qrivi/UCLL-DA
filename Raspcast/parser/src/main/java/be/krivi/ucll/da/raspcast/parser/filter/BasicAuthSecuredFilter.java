package be.krivi.ucll.da.raspcast.parser.filter;


import be.krivi.ucll.da.raspcast.parser.config.Config;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Base64;

@Provider
@BasicAuthSecured
@Priority( Priorities.AUTHENTICATION )
public class BasicAuthSecuredFilter implements ContainerRequestFilter, ContainerResponseFilter{

    @Override
    public void filter( ContainerRequestContext requestContext ) throws IOException{

        requestContext.getHeaders().add( HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"Raspcast API private parser\"" );

        try{
            String authorizationHeader = requestContext.getHeaderString( HttpHeaders.AUTHORIZATION );
            String base64 = authorizationHeader.substring( "Basic".length() ).trim();

            if( !base64.equals( Base64.getEncoder().encodeToString( ( Config.AUTH_USER + ":" + Config.AUTH_PASS ).getBytes() ) ) )
                throw new WebApplicationException();

        }catch( Exception e ){
            requestContext.abortWith(
                    Response.status( Response.Status.UNAUTHORIZED )
                            .entity( "HTTP 401 Unauthorized" )
                            .build() );
        }
    }

    @Override
    public void filter( ContainerRequestContext requestContext, ContainerResponseContext responseContext ) throws IOException{

        responseContext.getHeaders().add( HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"Raspcast API private parser\"" );
    }
}