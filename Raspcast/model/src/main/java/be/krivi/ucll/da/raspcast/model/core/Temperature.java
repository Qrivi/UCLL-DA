package be.krivi.ucll.da.raspcast.model.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table( name = "temperature" )
public class Temperature{

    @Id
    @GeneratedValue
    private Integer id;

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

    public Integer getId(){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
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