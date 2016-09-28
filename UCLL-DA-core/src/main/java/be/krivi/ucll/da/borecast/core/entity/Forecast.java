package be.krivi.ucll.da.borecast.core.entity;

import java.time.LocalDate;

/**
 * Created by Jan on 28/09/2016.
 */

public class Forecast{

    private LocalDate date;
    private Condition condition;
    private Temperature temperature;
    private double humidity;
    private double pressure;
    private Wind wind;

    public Forecast(){
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate( LocalDate date ){
        this.date = date;
    }

    public Condition getCondition(){
        return condition;
    }

    public void setCondition( Condition condition ){
        this.condition = condition;
    }

    public Temperature getTemperature(){
        return temperature;
    }

    public void setTemperature( Temperature temperature ){
        this.temperature = temperature;
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

    public Wind getWind(){
        return wind;
    }

    public void setWind( Wind wind ){
        this.wind = wind;
    }
}
