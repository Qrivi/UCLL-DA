package be.krivi.ucll.da.borecast.core.service;

import be.krivi.ucll.da.borecast.core.entity.City;
import be.krivi.ucll.da.borecast.core.repository.CityRepository;

import java.util.Set;

/**
 * Created by Jan on 28/09/2016.
 */

public class Facade{

    private CityRepository repository;

    public Facade(){
        repository = new CityRepository();
    }

    public Set<String> getCities(){
        return repository.getCities();
    }

    public void addCity( City city ){
        repository.addCity( city );
    }

    public City getCity( String name ){
        return repository.getCity( name );
    }

    public void deleteCity( String name ){
        repository.deleteCity( name );
    }
}
