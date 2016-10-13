package be.krivi.ucll.da.borecast.core.model;

import be.krivi.ucll.da.borecast.core.common.Identifiable;

/**
 * Created by Jan on 28/09/2016.
 */

public class Condition extends Identifiable{

    private String title;
    private String description;
    private String icon;

    private double cloudDensity;
    private double rainPossibility;
    private double snowPossibility;

    public Condition(){
    }

    public String getTitle(){
        return title;
    }

    public void setTitle( String title ){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription( String description ){
        this.description = description;
    }

    public String getIcon(){
        return icon;
    }

    public void setIcon( String icon ){
        this.icon = icon;
    }

    public double getCloudDensity(){
        return cloudDensity;
    }

    public void setCloudDensity( double cloudDensity ){
        this.cloudDensity = cloudDensity;
    }

    public double getRainPossibility(){
        return rainPossibility;
    }

    public void setRainPossibility( double rainPossibility ){
        this.rainPossibility = rainPossibility;
    }

    public double getSnowPossibility(){
        return snowPossibility;
    }

    public void setSnowPossibility( double snowPossibility ){
        this.snowPossibility = snowPossibility;
    }
}
