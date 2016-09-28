package be.krivi.ucll.da.borecast.core.converter;

/**
 * Created by Krivi on 27/09/2016.
 */

public class KelvinConverter{

    public static double toCelsius( double kelvin ){
        return kelvin - 273.15;
    }

    public static double toFahrenheit( double kelvin ){
        return kelvin * ( 9 / 5 );
    }
}
