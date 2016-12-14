package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.db.common.CRUD;
import be.krivi.ucll.da.raspcast.model.exception.DatabaseException;

import java.time.LocalDateTime;

public interface HumidityDB extends CRUD<Humidity, Integer>{

    Humidity getByDateTime( LocalDateTime dateTime ) throws DatabaseException;
}
