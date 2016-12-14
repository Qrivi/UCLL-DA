package be.krivi.ucll.da.raspcast.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class UserData{

    private String username;
    private String password;

    public UserData(){
    }

    public String getUsername(){
        return username;
    }

    public void setUsername( String username ){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword( String password ){
        this.password = password;
    }
}
