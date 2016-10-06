package be.krivi.ucll.da.borecast.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Krivi on 27/09/2016.
 */

@JsonIgnoreProperties( ignoreUnknown = true )
public class Weather{

    public String main;
    public String description;
    public String icon;

    public Weather(){
    }

    public String getMain(){
        return main;
    }

    public void setMain( String main ){
        this.main = main;
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
}
