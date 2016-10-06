package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.common.CRUDJPADatabase;
import be.krivi.ucll.da.borecast.core.model.Condition;
import be.krivi.ucll.da.borecast.core.model.Temperature;

public class TemperatureRDB extends CRUDJPADatabase<Temperature> implements TemperatureRepository{

    public TemperatureRDB( String name ){
        super( name, Temperature.class );
    }
}
