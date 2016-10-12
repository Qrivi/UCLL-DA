package be.krivi.ucll.da.borecast.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Krivi on 22/09/2016.
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class Response{

    public String cod; // HTTP status code
    public City city;
    public List<Forecast> list;

    public Response( List<Forecast> list ){
        this.list = list;
    }

    public Response(){
    }

    public String getCod(){
        return cod;
    }

    public void setCod( String cod ){
        this.cod = cod;
    }

    public City getCity(){
        return city;
    }

    public void setCity( City city ){
        this.city = city;
    }

    public List<Forecast> getList(){
        return list;
    }

    public void setList( List<Forecast> list ){
        this.list = list;
    }
}
