package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.db.common.CRUDJPADatabase;
import be.krivi.ucll.da.raspcast.model.core.Humidity;

/**
 * Created by Krivi on 16/11/2016.
 */

public class HumidityRDB extends CRUDJPADatabase<Humidity> implements HumidityDB{

    public HumidityRDB( String name ){
        super( name, Humidity.class );

    }
}
