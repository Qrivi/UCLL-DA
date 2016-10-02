package be.krivi.ucll.da.borecast.core.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Krivi on 22/09/2016.
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class Temp{

    public double day;
    public double min;
    public double max;
    public double night;
    public double eve;
    public double morn;

    public Temp(){
    }

    public double getDay(){
        return day;
    }

    public void setDay( double day ){
        this.day = day;
    }

    public double getMin(){
        return min;
    }

    public void setMin( double min ){
        this.min = min;
    }

    public double getMax(){
        return max;
    }

    public void setMax( double max ){
        this.max = max;
    }

    public double getNight(){
        return night;
    }

    public void setNight( double night ){
        this.night = night;
    }

    public double getEve(){
        return eve;
    }

    public void setEve( double eve ){
        this.eve = eve;
    }

    public double getMorn(){
        return morn;
    }

    public void setMorn( double morn ){
        this.morn = morn;
    }
}
