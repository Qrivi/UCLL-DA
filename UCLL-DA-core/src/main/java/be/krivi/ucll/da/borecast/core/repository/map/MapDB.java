package be.krivi.ucll.da.borecast.core.repository.map;


import be.krivi.ucll.da.borecast.core.common.Database;
import be.krivi.ucll.da.borecast.core.common.Identifiable;

import java.util.HashMap;
import java.util.Map;

public abstract class MapDB<E extends Identifiable> implements Database{

    protected Map<Integer, E> map;
    private int index;

    public MapDB(){
        this.index = 0;
        this.map = new HashMap<>();
    }

    protected int generateId(){
        return ( index++ );
    }

    public void openConnexion(){
        this.map = new HashMap<>();
    }

    public void closeConnexion(){
        this.map.clear();
    }
}
