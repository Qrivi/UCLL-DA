package be.krivi.ucll.da.raspcast.core;

import java.time.LocalDate;

/**
 * Created by Krivi on 13/10/2016.
 */

public class Humidity{
    
    private int id;
    private LocalDate timestamp;
    private double data;

    public Humidity(){
    }

    public LocalDate getTimestamp(){
        return timestamp;
    }

    public void setTimestamp( LocalDate timestamp ){
        this.timestamp = timestamp;
    }

    public double getData(){
        return data;
    }

    public void setData( double data ){
        this.data = data;
    }
}
