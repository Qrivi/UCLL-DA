package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.Temperature;
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
public class TemperatureRDB /*extends CRUDJPADatabase<Temperature> implements TemperatureDB*/{

    @PersistenceContext( unitName = "raspcast-persist" )
    private EntityManager manager;
    
    public TemperatureRDB(){
        
    }

    public Temperature add( Temperature obj ){
        try{
            manager.persist( obj );
            manager.flush();
            return obj;
        }catch( Exception e ){
            throw new DatabaseException( "Adding object to database failed: " + obj, e );
        }
    }


    public Temperature update( Temperature obj ){
        try{
            Temperature o = manager.merge( obj );
            return o;
        }catch( Exception e ){
            throw new DatabaseException( "Updating object in database failed: " + obj, e );
        }
    }

    public void delete( Temperature obj ){
        try{
            manager.remove( manager.contains( obj ) ? obj : manager.merge( obj ) );
        }catch( Exception e ){
            throw new DatabaseException( "Removing object from database failed: " + obj, e );
        }
    }


    public Temperature getByDateTime( LocalDateTime dateTime ) throws DatabaseException{
        try{
            return manager.find( Temperature.class, dateTime );
        }catch( Exception e ){
            throw new DatabaseException( "Fetching object from database failed: " + dateTime, e );
        }
    }

    public Collection<Temperature> getAll() throws DatabaseException{
        //        EntityManager manager = createManager();
        try{
            return manager.createQuery( "SELECT a FROM " + Temperature.class.getName() + " a", Temperature.class ).getResultList();
        }catch( NoResultException ex ){
            return new ArrayList<>();
        }catch( Exception e ){
            throw new DatabaseException( e );
        }//finally{
        //            manager.close();
        //        }
    }
    
    
    
    
    
}
