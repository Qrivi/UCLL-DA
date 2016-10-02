package be.krivi.ucll.da.borecast.core.repository.map;


import be.krivi.ucll.da.borecast.core.common.CRUD;
import be.krivi.ucll.da.borecast.core.common.Identifiable;
import be.krivi.ucll.da.borecast.core.exception.DatabaseException;

import java.util.Collection;

public abstract class CRUDMapDB<E extends Identifiable> extends MapDB<E> implements CRUD<E, Integer>{

    public CRUDMapDB(){
        super();
    }

    @Override
    public E getById( Integer id ) throws DatabaseException{
        return map.get( id );
    }

    @Override
    public Collection<E> getAll() throws DatabaseException{
        return map.values();
    }

    @Override
    public E add( E entity ) throws DatabaseException{
        if( entity == null )
            throw new DatabaseException( "Cannot add empty model data" );
        int id = generateId();
        entity.setId( id );
        map.put( id, entity );
        return entity;
    }

    @Override
    public void delete( E entity ) throws DatabaseException{
        if( entity == null )
            throw new DatabaseException( "Cannot remove empty model data" );
        if( !map.containsKey( entity.getId() ) )
            throw new DatabaseException( "Identifiable to delete does not exist" );
        map.remove( entity.getId() );
    }

    @Override
    public E update( E entity ) throws DatabaseException{
        if( entity == null )
            throw new DatabaseException( "Cannot update empty model data" );
        if( !map.containsKey( entity.getId() ) )
            throw new DatabaseException( "Identifiable to update does not exist" );
        map.put( entity.getId(), entity );
        return entity;
    }
}
