package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.model.Temperature;
import be.krivi.ucll.da.borecast.core.repository.map.CRUDMapDB;

public class TemperatureMap extends CRUDMapDB<Temperature> implements TemperatureRepository{

    public TemperatureMap(){
        super();
    }
}
