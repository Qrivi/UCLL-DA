package be.krivi.ucll.da.borecast.core.repository;

import be.krivi.ucll.da.borecast.core.common.CRUDJPADatabase;
import be.krivi.ucll.da.borecast.core.model.City;
import be.krivi.ucll.da.borecast.core.exception.DatabaseException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class CityRDB extends CRUDJPADatabase<City> implements CityRepository{

    public CityRDB( String name ){
        super( name, City.class );
    }

    @Override
    public City getByName( String name ) throws DatabaseException{
        EntityManager manager = createManager();
        try{
            return manager.createQuery( "SELECT n FROM City n WHERE n.name = :name", City.class )
                    .setParameter( "name", name ).getSingleResult();
        }catch( NoResultException ex ){
            return null;
        }catch( Exception e ){
            throw new DatabaseException( e );
        }finally{
            manager.close();
        }
    }
}
