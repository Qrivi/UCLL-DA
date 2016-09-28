package be.krivi.ucll.da.borecast.core.entity;

/**
 * Created by Jan on 28/09/2016.
 */

public class Temperature{

    private double day;
    private double min;
    private double max;
    private double night;
    private double eve;

    public Temperature(){
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

    private double morn;

}
