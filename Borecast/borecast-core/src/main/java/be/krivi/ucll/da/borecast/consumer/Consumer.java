package be.krivi.ucll.da.borecast.consumer;

import be.krivi.ucll.da.borecast.consumer.config.Config;
import be.krivi.ucll.da.borecast.consumer.model.Response;
import be.krivi.ucll.da.borecast.consumer.model.Temp;
import be.krivi.ucll.da.borecast.consumer.model.Weather;
import be.krivi.ucll.da.borecast.core.model.*;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Krivi on 06/10/2016.
 */


@RequestScoped
@Consumes( "application/json" )
public class Consumer{

    private Client client;

    public Consumer(){
        client = ClientBuilder.newClient();
    }

    public List<Forecast> fetchForecastForCity( City city ){

        List<Forecast> result = new LinkedList<>();

        WebTarget target = client
                .target( "http://api.openweathermap.org/data/" + Config.OWM_API_VERSION + "/forecast/daily" )
                .queryParam( "appid", Config.OWM_API_KEY )
                .queryParam( "q", city.getName() + "," + city.getCountry() );

        Response response = target.request( MediaType.APPLICATION_JSON ).get( Response.class );

        if( "200".equals( response.getCod() ) ){
            for( be.krivi.ucll.da.borecast.consumer.model.Forecast data : response.getList() ){
                Forecast f = new Forecast();

                City ci = new City();
                ci.setName( response.getCity().getName() );
                ci.setCountry( response.getCity().getCountry() );
                ci.setLat( response.getCity().getCoord().getLat() );
                ci.setLon( response.getCity().getCoord().getLon() );
                f.setCity( ci );

                f.setDate( LocalDateTime.ofInstant( Instant.ofEpochSecond( data.getDt() ), ZoneId.systemDefault() ) );

                Condition c = new Condition();
                Weather weather = data.getWeather();
                c.setTitle( weather.getMain() );
                c.setDescription( weather.getDescription() );
                c.setIcon( weather.getIcon() );

                c.setCloudDensity( data.getClouds() );
                c.setRainPossibility( data.getRain() );
                c.setSnowPossibility( data.getSnow() );
                f.setCondition( c );

                Temperature t = new Temperature();
                Temp temp = data.getTemp();
                t.setDay( temp.getDay() );
                t.setMin( temp.getMin() );
                t.setMax( temp.getMax() );
                t.setNight( temp.getNight() );
                t.setEve( temp.getEve() );
                t.setMorn( temp.getMorn() );
                f.setTemperature( t );

                f.setHumidity( data.getHumidity() );
                f.setPressure( data.getPressure() );

                Wind w = new Wind();
                w.setSpeed( data.getSpeed() );
                w.setDirection( data.getDeg() );
                f.setWind( w );

                result.add( f );
            }
        }
        return result;
    }
}
