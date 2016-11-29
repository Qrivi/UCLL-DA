package be.krivi.ucll.da.raspcast.model.exception;

public class DatabaseException extends RuntimeException{

    public DatabaseException(){
        super();
    }

    public DatabaseException( String message ){
        super( message );
    }

    public DatabaseException( Throwable throwable ){
        super( throwable );
    }

    public DatabaseException( String message, Throwable exception ){
        super( message, exception );
    }

}
