package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.Temperature;
import be.krivi.ucll.da.raspcast.model.db.common.CRUD;
import be.krivi.ucll.da.raspcast.model.exception.DatabaseException;

import java.time.LocalDateTime;

public interface TemperatureDB extends CRUD<Temperature, Integer>{

    Temperature getByDateTime( LocalDateTime dateTime ) throws DatabaseException;
}
