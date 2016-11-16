package be.krivi.ucll.da.raspcast.parser.exception;

/**
 * Created by Krivi on 16/11/2016.
 */

public class ReadException extends RuntimeException{

    public ReadException(){
        super();
    }

    public ReadException( String message ){
        super( message );
    }

    public ReadException( Throwable throwable ){
        super( throwable );
    }

    public ReadException( String message, Throwable exception ){
        super( message, exception );
    }

}