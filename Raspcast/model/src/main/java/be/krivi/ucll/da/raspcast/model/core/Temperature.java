package be.krivi.ucll.da.raspcast.model.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table( name = "temperature" )
public class Temperature{

    @Id
    @NotNull( message = "{NotNull.Temperature.datetime}" )
    @Column( name = "dateTime", unique = true )
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