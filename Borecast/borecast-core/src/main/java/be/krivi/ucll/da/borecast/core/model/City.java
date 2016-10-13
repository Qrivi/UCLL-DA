package be.krivi.ucll.da.borecast.core.model;

import be.krivi.ucll.da.borecast.core.common.Identifiable;

/**
 * Created by Krivi on 27/09/2016.
 */

public class City extends Identifiable{

    private String name;
    private String country;
    private double lat;
    private double lon;

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

    @Override
    public boolean equals( Object o ){
        if( this == o ) return true;
        if( o == null || getClass() != o.getClass() ) return false;

        City city = (City)o;

        if( !name.equalsIgnoreCase( city.name ) ) return false;
        return country.equalsIgnoreCase( city.country );
    }

    @Override
    public int hashCode(){
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }
}
