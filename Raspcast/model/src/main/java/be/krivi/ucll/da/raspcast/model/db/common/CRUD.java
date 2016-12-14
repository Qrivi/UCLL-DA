package be.krivi.ucll.da.raspcast.model.db.common;

import be.krivi.ucll.da.raspcast.model.exception.DatabaseException;

import java.util.Collection;

public interface CRUD<E, K>{

    E getById( K id ) throws DatabaseException;

    Collection<E> getAll() throws DatabaseException;

    E add( E entity ) throws DatabaseException;

    void delete( E entity ) throws DatabaseException;

    E update( E entity ) throws DatabaseException;
}