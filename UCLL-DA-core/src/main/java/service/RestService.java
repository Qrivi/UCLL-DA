package service;

import config.Config;
import entity.rest.Response;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Krivi on 23/09/2016.
 */

public class RestService{

    private static String OWM_API_URL = "http://api.openweathermap.org/data/{version}/forecast/daily?appid={key}&q={location}";

    public void fetchForecast( String location ){

        RestTemplate template = new RestTemplate();

        try{
            Response response = template.getForObject( OWM_API_URL, Response.class, Config.OWM_API_VERSION, Config.OWM_API_KEY, location );

            System.out.println( "cool" );
        }catch( RestClientException e ){
            System.out.println( "niet cool" );
        }
    }
}
