package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.common.CRUDJPADatabase;
import be.krivi.ucll.da.borecast.core.model.Condition;

public class ConditionRDB extends CRUDJPADatabase<Condition> implements ConditionRepository{

    public ConditionRDB( String name ){
        super( name, Condition.class );
    }
}
