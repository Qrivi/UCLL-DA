package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.Temperature;
import be.krivi.ucll.da.raspcast.model.db.common.CRUD;

import java.time.LocalDateTime;

/**
 * Created by Krivi on 16/11/2016.
 */

public interface TemperatureDB extends CRUD<Temperature, LocalDateTime>{
}
