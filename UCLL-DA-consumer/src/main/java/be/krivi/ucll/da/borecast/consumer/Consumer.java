package be.krivi.ucll.da.borecast.consumer;

import be.krivi.ucll.da.borecast.consumer.config.Config;
import be.krivi.ucll.da.borecast.consumer.model.Response;
import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.model.Forecast;
import be.krivi.ucll.da.borecast.core.service.BorecastService;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Krivi on 06/10/2016.
 */

public class Consumer{

    @Inject // how le constructor args tho?
    private BorecastService borecastService;
    private Client client;

    public Consumer(){
        client = ClientBuilder.newClient();
    }

    public List<Forecast> fetchForecastForCity( City city ){

        List<Forecast> result = new LinkedList<>(  );

        WebTarget target = client
                .target( "http://api.openweathermap.org/data/" + Config.OWM_API_VERSION + "/forecast/daily" )
                .queryParam( "appid", Config.OWM_API_KEY )
                .queryParam( "q", city.getName() + "," + city.getCountry() );

        Response response = target.request( MediaType.APPLICATION_JSON ).get( Response.class );

        if( "200".equals( response.getCod() ) ){
            for( be.krivi.ucll.da.borecast.consumer.model.Forecast data : response.getForecastList() ){


            }
        }
    }
}
