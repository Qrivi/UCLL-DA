package be.krivi.ucll.da.raspcast.parser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Krivi on 16/11/2016.
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class WeatherData{

    @JsonProperty( "humidity" )
    private double humidity;

    @JsonProperty( "temp" )
    private double temperature;

    public WeatherData(){
    }

    public double getHumidity(){
        return humidity;
    }

    public void setHumidity( double humidity ){
        this.humidity = humidity;
    }

    public double getTemperature(){
        return temperature;
    }

    public void setTemperature( double temperature ){
        this.temperature = temperature;
    }

    @Override
    public String toString(){
        return "H:" + humidity + ",T:"+ temperature;
    }
}
