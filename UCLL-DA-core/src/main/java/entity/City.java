package entity;

/**
 * Created by Krivi on 27/09/2016.
 */

public class City{

    public String name;
    public String country;
    public double lat;
    public double lon;

    public City(){
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
