package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.Temperature;
import be.krivi.ucll.da.raspcast.model.db.common.CRUDJPADatabase;

import javax.enterprise.context.Dependent;

/**
 * Created by Krivi on 16/11/2016.
 */

@Dependent
public class TemperatureRDB extends CRUDJPADatabase<Temperature> implements TemperatureDB{

    public TemperatureRDB(){
        super( Temperature.class );
    }
}
