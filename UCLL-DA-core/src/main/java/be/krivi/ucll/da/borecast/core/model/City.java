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
        if( !( o instanceof City ) ) return false;
        if( !super.equals( o ) ) return false;

        City city = (City)o;

        if( Double.compare( city.getLat(), getLat() ) != 0 ) return false;
        if( Double.compare( city.getLon(), getLon() ) != 0 ) return false;
        if( !getName().equals( city.getName() ) ) return false;
        return getCountry().equals( city.getCountry() );

    }

    @Override
    public int hashCode(){
        int result = super.hashCode();
        long temp;
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCountry().hashCode();
        temp = Double.doubleToLongBits( getLat() );
        result = 31 * result + (int)( temp ^ ( temp >>> 32 ) );
        temp = Double.doubleToLongBits( getLon() );
        result = 31 * result + (int)( temp ^ ( temp >>> 32 ) );
        return result;
    }
}
