package be.krivi.ucll.da.raspcast.parser.reader;

import be.krivi.ucll.da.raspcast.parser.dto.WeatherData;

import javax.ejb.Stateless;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Krivi on 16/11/2016.
 */

@Stateless
public class DummyReader implements Reader{

    @Override
    public WeatherData read(){

        WeatherData dummy = new WeatherData();
        dummy.setTemperature( round( random( -20, 40 ) ) );
        dummy.setHumidity( round( random( 0, 100 ) ) );

        return dummy;
    }

    private double random( double origin, double bound ){
        return ThreadLocalRandom.current().nextDouble( origin, bound + 1 );
    }

    private double round( double value ){
        return (double)Math.round( value * 100 ) / 100;
    }
}