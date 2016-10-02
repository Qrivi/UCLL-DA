package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.common.CRUD;
import be.krivi.ucll.da.borecast.core.common.Database;
import be.krivi.ucll.da.borecast.core.entity.City;
import be.krivi.ucll.da.borecast.core.exception.DatabaseException;

/**
 * Created by Krivi on 27/09/2016.
 */

public interface CityRepository extends Database, CRUD<City, Integer>{

    City getByName( String name ) throws DatabaseException;
}
