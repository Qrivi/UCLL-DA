package be.krivi.ucll.da.raspcast.parser.filter;


import be.krivi.ucll.da.raspcast.parser.config.Config;
import com.sun.xml.internal.messaging.saaj.util.Base64;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@BasicAuthSecured
@Priority( Priorities.AUTHENTICATION )
public class BasicAuthSecuredFilter implements ContainerRequestFilter{

    @Override
    public void filter( ContainerRequestContext requestContext ) throws IOException{

        try{
            String authorizationHeader = requestContext.getHeaderString( HttpHeaders.AUTHORIZATION );
            String base64 = authorizationHeader.substring( "Basic".length() ).trim();

            if( !base64.equals( new String( new Base64().encode( ( Config.AUTH_USER + ":" + Config.AUTH_PASS ).getBytes() ) ) ) )
                throw new WebApplicationException();

        }catch( Exception e ){
            requestContext.abortWith(
                    Response.status( Response.Status.UNAUTHORIZED )
                            .entity( "HTTP 401 Unauthorized" )
                            .build() );
        }
    }
}