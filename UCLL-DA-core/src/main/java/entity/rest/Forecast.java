package entity.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Krivi on 22/09/2016.
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class Forecast{

    public LocalDate dt;
    public Main main;
    public List<Weather> weatherList;
    public Clouds clouds;

    public Forecast(){
    }

    public LocalDate getDt(){
        return dt;
    }

    public void setDt( LocalDate dt ){
        this.dt = dt;
    }

    public Main getMain(){
        return main;
    }

    public void setMain( Main main ){
        this.main = main;
    }

    public List<Weather> getWeatherList(){
        return weatherList;
    }

    public void setWeatherList( List<Weather> weatherList ){
        this.weatherList = weatherList;
    }

    public Clouds getClouds(){
        return clouds;
    }

    public void setClouds( Clouds clouds ){
        this.clouds = clouds;
    }
}
