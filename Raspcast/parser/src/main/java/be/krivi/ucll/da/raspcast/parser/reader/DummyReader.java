package be.krivi.ucll.da.raspcast.parser.reader;

import be.krivi.ucll.da.raspcast.parser.dto.WeatherData;

import javax.enterprise.inject.Default;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Krivi on 16/11/2016.
 */

@Default
public class DummyReader implements Reader{

    @Override
    public WeatherData read(){

        WeatherData dummy = new WeatherData();
        dummy.setHumidity( ThreadLocalRandom.current().nextInt( -20, 40 + 1 ) / 10 );
        dummy.setHumidity( ThreadLocalRandom.current().nextInt( 0, 1000 + 1 ) / 10 );

        return dummy;
    }
}
