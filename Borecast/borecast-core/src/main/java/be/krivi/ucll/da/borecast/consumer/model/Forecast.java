package be.krivi.ucll.da.borecast.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Krivi on 27/09/2016.
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class Forecast{


    public long dt;
    public Temp temp;
    public Weather weather;
    public double humidity;
    public double pressure;
    public double speed;
    public double deg;
    public double clouds;
    public double snow;
    public double rain;

    public Forecast(){
    }

    public long getDt(){
        return dt;
    }

    public void setDt( long dt ){
        this.dt = dt;
    }

    public Temp getTemp(){
        return temp;
    }

    public void setTemp( Temp temp ){
        this.temp = temp;
    }

    public Weather getWeather(){
        return weather;
    }

    public void setWeather( Weather weather ){
        this.weather = weather;
    }

    public double getHumidity(){
        return humidity;
    }

    public void setHumidity( double humidity ){
        this.humidity = humidity;
    }

    public double getPressure(){
        return pressure;
    }

    public void setPressure( double pressure ){
        this.pressure = pressure;
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

    public double getClouds(){
        return clouds;
    }

    public void setClouds( double clouds ){
        this.clouds = clouds;
    }

    public double getSnow(){
        return snow;
    }

    public void setSnow( double snow ){
        this.snow = snow;
    }

    public double getRain(){
        return rain;
    }

    public void setRain( double rain ){
        this.rain = rain;
    }
}
