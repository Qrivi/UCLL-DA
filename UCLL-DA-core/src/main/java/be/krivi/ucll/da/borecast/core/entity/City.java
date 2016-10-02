package be.krivi.ucll.da.borecast.core.entity;

import be.krivi.ucll.da.borecast.core.common.Identifiable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Krivi on 27/09/2016.
 */

public class City extends Identifiable{

    private String name;
    private String country;
    private double lat;
    private double lon;
    private List<Forecast> forecastList;

    public City(){
        forecastList = new LinkedList<>();
    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry( String country ){
        this.country = country;
    }

    public double getLat(){
        return lat;
    }

    public void setLat( double lat ){
        this.lat = lat;
    }

    public double getLon(){
        return lon;
    }

    public void setLon( double lon ){
        this.lon = lon;
    }
}
