package entity.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Krivi on 22/09/2016.
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class Main{

    public int temp;
    public int temp_max;
    public int temp_min;
    public int humidity;

    public Main(){
    }

    public int getTemp(){
        return temp;
    }

    public void setTemp( int temp ){
        this.temp = temp;
    }

    public int getTemp_max(){
        return temp_max;
    }

    public void setTemp_max( int temp_max ){
        this.temp_max = temp_max;
    }

    public int getTemp_min(){
        return temp_min;
    }

    public void setTemp_min( int temp_min ){
        this.temp_min = temp_min;
    }

    public int getHumidity(){
        return humidity;
    }

    public void setHumidity( int humidity ){
        this.humidity = humidity;
    }
}
