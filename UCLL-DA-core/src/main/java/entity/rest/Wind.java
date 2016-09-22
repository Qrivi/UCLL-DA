package entity.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Krivi on 22/09/2016.
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class Wind{

    public double speed;
    public double deg;

    public Wind(){
    }

    public double getSpeed(){
        return speed;
    }

    public void setSpeed( double speed ){
        this.speed = speed;
    }

    public double getDeg(){
        return deg;
    }

    public void setDeg( double deg ){
        this.deg = deg;
    }
}
