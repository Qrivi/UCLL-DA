package be.krivi.ucll.da.borecast.core.model;

import be.krivi.ucll.da.borecast.core.common.Identifiable;

/**
 * Created by Jan on 28/09/2016.
 */

public class Wind extends Identifiable{

    private double speed;
    private double direction;

    public Wind(){
    }

    public double getSpeed(){
        return speed;
    }

    public void setSpeed( double speed ){
        this.speed = speed;
    }

    public double getDirection(){
        return direction;
    }

    public void setDirection( double direction ){
        this.direction = direction;
    }
}
