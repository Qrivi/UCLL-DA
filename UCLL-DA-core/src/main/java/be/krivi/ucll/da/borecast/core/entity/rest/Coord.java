package be.krivi.ucll.da.borecast.core.entity.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Krivi on 27/09/2016.
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class Coord{

    public double lat;
    public double lon;

    public Coord(){
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
