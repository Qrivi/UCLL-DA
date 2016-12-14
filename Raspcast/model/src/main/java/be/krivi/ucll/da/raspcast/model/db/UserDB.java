package be.krivi.ucll.da.raspcast.model.db;

import be.krivi.ucll.da.raspcast.model.core.User;
import be.krivi.ucll.da.raspcast.model.db.common.CRUD;
import be.krivi.ucll.da.raspcast.model.exception.DatabaseException;

public interface UserDB extends CRUD<User, Integer>{

    User getByUserName( String userName ) throws DatabaseException;
}
