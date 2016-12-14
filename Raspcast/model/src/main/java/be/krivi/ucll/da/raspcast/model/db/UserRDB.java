package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.Temperature;
import be.krivi.ucll.da.raspcast.model.core.User;
import be.krivi.ucll.da.raspcast.model.db.common.CRUDJPADatabase;

import javax.enterprise.context.Dependent;

@Dependent
public class UserRDB extends CRUDJPADatabase<User> implements UserDB{

    public UserRDB(){
        super( User.class );
    }
}
