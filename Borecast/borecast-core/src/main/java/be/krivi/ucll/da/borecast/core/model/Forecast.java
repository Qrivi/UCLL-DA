package be.krivi.ucll.da.borecast.core.model;

import be.krivi.ucll.da.borecast.core.common.Identifiable;

import java.time.LocalDateTime;

/**
 * Created by Jan on 28/09/2016.
 */

public class Forecast extends Identifiable{

    private City city;
    private LocalDateTime date;
    private Condition condition;
    private Temperature temperature;
    private double humidity;
    private double pressure;
    private Wind wind;

    public Forecast(){
    }

    public City getCity(){
        return city;
    }

    public void setCity( City city ){
        this.city = city;
    }

    public LocalDateTime getDate(){
        return date;
    }

    public void setDate( LocalDateTime date ){
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

    @Override
    public String toString(){
        return "Forecast{" +
                "city=" + city.getName() +
                ", date=" + date +
                ", temperature=" + temperature.getDay() +
                '}';
    }
}
