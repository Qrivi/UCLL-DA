package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.User;
import be.krivi.ucll.da.raspcast.model.db.common.CRUDJPADatabase;
import be.krivi.ucll.da.raspcast.model.exception.DatabaseException;

import javax.enterprise.context.Dependent;
import javax.persistence.NoResultException;

@Dependent
public class UserRDB extends CRUDJPADatabase<User> implements UserDB{

    public UserRDB(){
        super( User.class );
    }

    @Override
    public User getByUserName( String userName ) throws DatabaseException{
        try{
            return manager.createQuery( "SELECT u FROM User u WHERE u.userName = :userName", User.class )
                    .setParameter( "userName", userName )
                    .getSingleResult();
        }catch( NoResultException e ){
            return null;
        }catch( Exception e ){
            throw new DatabaseException( "Fetching object from database failed: " + userName, e );
        }
    }
}
