package be.krivi.ucll.da.raspcast.parser.reader;

/**
 * Created by Krivi on 16/11/2016.
 */

public class ReaderFactory{

    public static Reader getReader( String type ) throws Exception{
        Class<?> readerClass = Class.forName( type );
        return (Reader)readerClass.newInstance();
    }
}