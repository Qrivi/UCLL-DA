package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.exception.DatabaseException;
import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.repository.map.CRUDMapDB;

public class CityMap extends CRUDMapDB<City> implements CityRepository{

    public CityMap(){
        super();
    }

    @Override
    public City getByName( String name ) throws DatabaseException{
        return map.values().stream().filter( ( n ) -> n.getName().equals( name ) ).findFirst().get();
    }
}
