package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.db.common.CRUDJPADatabase;

import javax.enterprise.context.Dependent;

@Dependent
public class HumidityRDB extends CRUDJPADatabase<Humidity> implements HumidityDB{

    public HumidityRDB(){
        super( Humidity.class );
    }
}
