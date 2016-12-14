package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.Humidity;
import be.krivi.ucll.da.raspcast.model.db.common.CRUDJPADatabase;
import be.krivi.ucll.da.raspcast.model.exception.DatabaseException;

import javax.enterprise.context.Dependent;
import javax.persistence.NoResultException;
import java.time.LocalDateTime;

@Dependent
public class HumidityRDB extends CRUDJPADatabase<Humidity> implements HumidityDB{

    public HumidityRDB(){
        super( Humidity.class );
    }

    @Override
    public Humidity getByDateTime( LocalDateTime dateTime ) throws DatabaseException{
        try{
            return manager.createQuery( "SELECT h FROM Humidity h WHERE h.dateTime = :dateTime", Humidity.class )
                    .setParameter( "dateTime", dateTime )
                    .getSingleResult();
        }catch( NoResultException e ){
            return null;
        }catch( Exception e ){
            throw new DatabaseException( "Fetching object from database failed: " + dateTime, e );
        }
    }
}
