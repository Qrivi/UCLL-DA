package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.common.CRUDJPADatabase;
import be.krivi.ucll.da.borecast.core.model.Wind;

public class WindRDB extends CRUDJPADatabase<Wind> implements WindRepository{

    public WindRDB( String name ){
        super( name, Wind.class );
    }
}
