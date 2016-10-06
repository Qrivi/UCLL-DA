package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.common.CRUD;
import be.krivi.ucll.da.borecast.core.common.Database;
import be.krivi.ucll.da.borecast.core.model.Temperature;

/**
 * Created by Krivi on 27/09/2016.
 */

public interface TemperatureRepository extends Database, CRUD<Temperature, Integer>{
}
