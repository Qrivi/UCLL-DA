package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.common.CRUDJPADatabase;
import be.krivi.ucll.da.borecast.core.exception.DatabaseException;
import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.model.Forecast;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class ForecastRDB extends CRUDJPADatabase<Forecast> implements ForecastRepository{

    public ForecastRDB( String name ){
        super( name, Forecast.class );
    }

    @Override
    public List<Forecast> getByCity( City city ) throws DatabaseException{
        EntityManager manager = createManager();
        try{
            return manager.createQuery( "SELECT n FROM Forecast n WHERE n.city = :city", Forecast.class )
                    .setParameter( "city", city ).getResultList();
        }catch( NoResultException ex ){
            return null;
        }catch( Exception e ){
            throw new DatabaseException( e );
        }finally{
            manager.close();
        }
    }
}
