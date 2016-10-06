package be.krivi.ucll.da.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Krivi on 27/09/2016.
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class City{

    public String name;
    public Coord coord;
    public String country;

    public City(){
    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public Coord getCoord(){
        return coord;
    }

    public void setCoord( Coord coord ){
        this.coord = coord;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry( String country ){
        this.country = country;
    }
}
