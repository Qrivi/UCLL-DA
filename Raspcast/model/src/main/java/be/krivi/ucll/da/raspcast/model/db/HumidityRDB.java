package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.exception.DatabaseException;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Krivi on 16/11/2016.
 */

@Dependent
public class HumidityRDB /*implements HumidityDB*/{

    @PersistenceContext( unitName = "raspcast-persist" )
    private EntityManager manager;

    public HumidityRDB( ){
    }

    public Humidity add( Humidity obj ){
        try{
            manager.persist( obj );
            manager.flush();
            return obj;
        }catch( Exception e ){
            throw new DatabaseException( "Adding object to database failed: " + obj, e );
        }
    }


    public Humidity update( Humidity obj ){
        try{
            Humidity o = manager.merge( obj );
            return o;
        }catch( Exception e ){
            throw new DatabaseException( "Updating object in database failed: " + obj, e );
        }
    }

    public void delete( Humidity obj ){
        try{
            manager.remove( manager.contains( obj ) ? obj : manager.merge( obj ) );
        }catch( Exception e ){
            throw new DatabaseException( "Removing object from database failed: " + obj, e );
        }
    }


    public Humidity getByDateTime( LocalDateTime dateTime ) throws DatabaseException{
        try{
            return manager.find( Humidity.class, dateTime );
        }catch( Exception e ){
            throw new DatabaseException( "Fetching object from database failed: " + dateTime, e );
        }
    }

    public Collection<Humidity> getAll() throws DatabaseException{
        //        EntityManager manager = createManager();
        try{
            return manager.createQuery( "SELECT a FROM " + Humidity.class.getName() + " a", Humidity.class ).getResultList();
        }catch( NoResultException ex ){
            return new ArrayList<>();
        }catch( Exception e ){
            throw new DatabaseException( e );
        }//finally{
        //            manager.close();
        //        }
    }
}
