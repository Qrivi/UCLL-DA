package be.krivi.ucll.da.raspcast.model.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Krivi on 13/10/2016.
 */

@Entity
@Table( name = "humidity" )
public class Humidity{

    @Id
    @NotNull( message = "{NotNull.Humidity.datetime}" )
    @Column( name = "dateTime", unique = true )
    private LocalDateTime dateTime;

    @Min( value = 0, message = "{Min.Humidity.data}" )
    @Max( value = 100, message = "{Max.Humidity.data}" )
    @Column( name = "humidity" )
    private double data;

    public Humidity(){
    }

    public Humidity( double data ){
        setDateTime( LocalDateTime.now() );
        setData( data );
    }

    public Humidity( double data, LocalDateTime dateTime ){
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
