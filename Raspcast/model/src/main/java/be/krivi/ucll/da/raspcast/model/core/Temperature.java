package be.krivi.ucll.da.raspcast.model.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Krivi on 13/10/2016.
 */

@Entity
@Table( name = "temperature" )
public class Temperature{

    @NotNull( message = "{NotNull.Temperature.datetime" )
    @Column( name = "dateTime" )
    private LocalDateTime dateTime;

    @Column( name = "temperature" )
    private double data;

    public Temperature(){
    }

    public Temperature( double data ){
        setDateTime( LocalDateTime.now() );
        setData( data );
    }

    public Temperature( double data, LocalDateTime dateTime ){
        setDateTime( dateTime );
        setData( data );
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setDateTime( LocalDateTime dateTime ){
        this.dateTime = dateTime;
    }

    public double getData(){
        return data;
    }

    public void setData( double data ){
        this.data = data;
    }
}
