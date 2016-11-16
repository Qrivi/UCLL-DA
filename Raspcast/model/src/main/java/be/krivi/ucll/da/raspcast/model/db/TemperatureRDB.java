package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.db.common.CRUDJPADatabase;
import be.krivi.ucll.da.raspcast.model.core.Temperature;

/**
 * Created by Krivi on 16/11/2016.
 */

public class TemperatureRDB extends CRUDJPADatabase<Temperature> implements TemperatureDB{

    public TemperatureRDB( String name ){
        super( name, Temperature.class );

    }
}
