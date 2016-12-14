package be.krivi.ucll.da.raspcast.api.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

public class LoggerProducer{

    @Produces
    public Logger produceLogger( InjectionPoint injectionPoint ){
        return Logger.getLogger( injectionPoint.getMember().getDeclaringClass().getName() );
    }
}
