package be.krivi.ucll.da.raspcast.parser.reader;

import be.krivi.ucll.da.raspcast.parser.dto.WeatherData;
import be.krivi.ucll.da.raspcast.parser.exception.ReadException;
import com.google.gson.Gson;

import javax.enterprise.inject.Alternative;
import java.io.IOException;

/**
 * Created by Krivi on 16/11/2016.
 */

@Alternative
public class PythonReader implements Reader{

    private String path;

    public PythonReader(){
    }

    public void setPath( String path ){
        this.path = path;
    }

    @Override
    public WeatherData read() throws ReadException{
        try{
            Gson g = new Gson();
            Process p = Runtime.getRuntime().exec( "python " + path );

            return g.fromJson( p.getOutputStream().toString(), WeatherData.class );

        }catch( IOException e ){
            throw new ReadException( e );
        }
    }
}
