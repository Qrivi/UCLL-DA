package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.common.CRUD;
import be.krivi.ucll.da.borecast.core.common.Database;
import be.krivi.ucll.da.borecast.core.exception.DatabaseException;
import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.model.Forecast;

import java.util.List;

/**
 * Created by Krivi on 27/09/2016.
 */

public interface ForecastRepository extends Database, CRUD<Forecast, Integer>{

    List<Forecast> getByCity( City city ) throws DatabaseException;

    List<Forecast> getByCity( String city ) throws DatabaseException;
}
