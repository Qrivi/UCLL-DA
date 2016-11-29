package be.krivi.ucll.da.raspcast.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class UserData{

    private String beforeDate;
    private String afterDate;
    private String date;

    public UserData(){
    }

    public String getBeforeDate(){
        return beforeDate;
    }

    public void setBeforeDate( String beforeDate ){
        this.beforeDate = beforeDate;
    }

    public String getAfterDate(){
        return afterDate;
    }

    public void setAfterDate( String afterDate ){
        this.afterDate = afterDate;
    }

    public String getDate(){
        return date;
    }

    public void setDate( String date ){
        this.date = date;
    }
}
