package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.model.Condition;
import be.krivi.ucll.da.borecast.core.repository.map.CRUDMapDB;

public class ConditionMap extends CRUDMapDB<Condition> implements ConditionRepository{

    public ConditionMap(){
        super();
    }
}
