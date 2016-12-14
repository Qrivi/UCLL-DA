package be.krivi.ucll.da.raspcast.api.util;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class SimpleKeyGenerator implements KeyGenerator{

    @Override
    public Key generateKey(){
        String keyString = "simplekey";
        Key key = new SecretKeySpec( keyString.getBytes(), 0, keyString.getBytes().length, "DES" );
        return key;
    }
}