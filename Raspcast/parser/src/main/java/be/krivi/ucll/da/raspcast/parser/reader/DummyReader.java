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
        dummy.setTemperature( ThreadLocalRandom.current().nextDouble( -20, 40 + 1 ) );
        dummy.setHumidity( ThreadLocalRandom.current().nextDouble( 0, 100 + 1 ) );

        return dummy;
    }
}
