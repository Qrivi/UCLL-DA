package be.krivi.ucll.da.raspcast.parser.reader;

public class ReaderFactory{

    public static Reader getReader( String type ) throws Exception{
        Class<?> readerClass = Class.forName( type );
        return (Reader)readerClass.newInstance();
    }
}