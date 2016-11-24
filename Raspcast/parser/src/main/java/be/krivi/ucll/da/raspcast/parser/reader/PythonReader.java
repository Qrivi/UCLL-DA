package be.krivi.ucll.da.raspcast.parser.reader;

import be.krivi.ucll.da.raspcast.parser.config.Config;
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

    public PythonReader(){
    }

    @Override
    public WeatherData read() throws ReadException{
        try{
            Process p = Runtime.getRuntime().exec( "python " + Config.PYTHON_PATH + " 2302 22" );

            return new ObjectMapper().readValue( p.getOutputStream().toString(), WeatherData.class );
        }catch( IOException e ){
            throw new ReadException( e );
        }
    }
}
