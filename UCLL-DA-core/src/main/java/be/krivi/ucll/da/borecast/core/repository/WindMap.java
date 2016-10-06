package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.model.Wind;
import be.krivi.ucll.da.borecast.core.repository.map.CRUDMapDB;

public class WindMap extends CRUDMapDB<Wind> implements WindRepository{

    public WindMap(){
        super();
    }
}
