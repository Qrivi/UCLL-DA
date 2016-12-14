package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.Temperature;
import be.krivi.ucll.da.raspcast.model.db.common.CRUDJPADatabase;
import be.krivi.ucll.da.raspcast.model.exception.DatabaseException;

import javax.enterprise.context.Dependent;
import javax.persistence.NoResultException;
import java.time.LocalDateTime;

@Dependent
public class TemperatureRDB extends CRUDJPADatabase<Temperature> implements TemperatureDB{

    public TemperatureRDB(){
        super( Temperature.class );
    }

    @Override
    public Temperature getByDateTime( LocalDateTime dateTime ) throws DatabaseException{
        try{
            return manager.createQuery( "SELECT t FROM Temperature t WHERE t.dateTime = :dateTime", Temperature.class )
                    .setParameter( "dateTime", dateTime )
                    .getSingleResult();
        }catch( NoResultException e ){
            return null;
        }catch( Exception e ){
            throw new DatabaseException( "Fetching object from database failed: " + dateTime, e );
        }
    }
}
