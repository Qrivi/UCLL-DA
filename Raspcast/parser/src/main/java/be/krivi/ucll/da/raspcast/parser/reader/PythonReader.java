package be.krivi.ucll.da.raspcast.parser.reader;

import be.krivi.ucll.da.raspcast.parser.dto.WeatherData;
import be.krivi.ucll.da.raspcast.parser.exception.ReadException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import java.io.IOException;

/**
 * Created by Krivi on 16/11/2016.
 */

@Stateless
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
            Process p = Runtime.getRuntime().exec( "python " + path );

            return new ObjectMapper().readValue( p.getOutputStream().toString(), WeatherData.class );
        }catch( IOException e ){
            throw new ReadException( e );
        }
    }
}
