package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.common.CRUDJPADatabase;
import be.krivi.ucll.da.borecast.core.entity.City;

public class CityRDB extends CRUDJPADatabase<City> implements CityRepository{

    public CityRDB( String name ){
        super( name, City.class );
    }
}
