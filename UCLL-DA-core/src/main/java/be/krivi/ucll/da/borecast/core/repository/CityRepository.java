package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.entity.City;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Krivi on 27/09/2016.
 */

public class CityRepository{

    private Map<String, City> cities;

    /*
        TODO REMOVE ME!
        Waarom MAP you ask?

        1. Als ge lijst wilt van alle steden dan moet ge niet itereren over ze allemaal maar enkel map.keys() vragen
        2. Als ge het object van een stad wilt moet ge niet eerst indexof doen of itereren over alle verschillende steden.
        3. Tis foking sjiek
     */
    public CityRepository(){
        this.cities = new HashMap<>();
    }

    public Set<String> getCities(){
        return cities.keySet();
    }

    public void addCity( City city ){
        if( cities.containsKey( city.getName() ) )
            cities.replace( city.getName(), city );
        else
            cities.put( city.getName(), city );
    }

    public City getCity( String name ){
        return cities.get( name );
    }

    public void deleteCity( String name ){
        cities.remove( name );
    }
}
