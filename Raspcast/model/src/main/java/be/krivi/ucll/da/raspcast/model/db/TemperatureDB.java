package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.Temperature;
import be.krivi.ucll.da.raspcast.model.db.common.CRUD;

import java.time.LocalDateTime;

public interface TemperatureDB extends CRUD<Temperature, LocalDateTime>{
}
