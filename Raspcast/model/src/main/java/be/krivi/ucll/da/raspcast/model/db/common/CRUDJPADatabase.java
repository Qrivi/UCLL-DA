package be.krivi.ucll.da.raspcast.model.db.common;

import be.krivi.ucll.da.raspcast.model.exception.DatabaseException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Krivi on 30/03/16.
 */

public abstract class CRUDJPADatabase<ENTITY> implements CRUD<ENTITY, LocalDateTime>{

    private final Class<ENTITY> typeClass;

    @PersistenceContext( unitName = "raspcast-persist" )
    private EntityManager manager;

    public CRUDJPADatabase( Class<ENTITY> typeClass ){
        this.typeClass = typeClass;
    }

    @Override
    public ENTITY add( ENTITY obj ){
        try{
            manager.persist( obj );
            manager.flush();
            return obj;
        }catch( Exception e ){
            throw new DatabaseException( "Adding object to database failed: " + obj, e );
        }
    }

    @Override
    public ENTITY update( ENTITY obj ){
        try{
            ENTITY o = manager.merge( obj );
            return o;
        }catch( Exception e ){
            throw new DatabaseException( "Updating object in database failed: " + obj, e );
        }
    }

    @Override
    public void delete( ENTITY obj ){
        try{
            manager.remove( manager.contains( obj ) ? obj : manager.merge( obj ) );
        }catch( Exception e ){
            throw new DatabaseException( "Removing object from database failed: " + obj, e );
        }
    }

    @Override
    public ENTITY getByDateTime( LocalDateTime dateTime ) throws DatabaseException{
        try{
            return manager.find( typeClass, dateTime );
        }catch( Exception e ){
            throw new DatabaseException( "Fetching object from database failed: " + dateTime, e );
        }
    }

    @Override
    public Collection<ENTITY> getAll() throws DatabaseException{
        try{
            return manager.createQuery( "SELECT a FROM " + typeClass.getName() + " a", typeClass ).getResultList();
        }catch( NoResultException ex ){
            return new ArrayList<>();
        }catch( Exception e ){
            throw new DatabaseException( e );
        }
    }
}