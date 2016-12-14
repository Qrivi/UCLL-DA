package be.krivi.ucll.da.raspcast.model.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "user" )
@JsonIgnoreProperties( {"id"} )
public class User{

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank( message = "{NotBlank.User.userName}" )
    @Column( name = "name", unique = true )
    private String userName;

    @NotBlank( message = "{NotBlank.User.password}" )
    @Column( name = "password" )
    private String password;

    @NotNull( message = "NotNull.User.status" )
    @Column( name = "status" )
    @Enumerated( EnumType.STRING )
    private UserStatus status;

    public User(){
    }

    public User( String userName, String plainPassword ){
        setUserName( userName );
        setPlainPassword( plainPassword );
        setStatus( UserStatus.ACTIVE );
    }

    public Integer getId(){
        return id;
    }

    public void setId( Integer id ){
        this.id = id;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName( String userName ){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPlainPassword( String plainPassword ){
        String salt = BCrypt.gensalt( 12 );
        this.password = BCrypt.hashpw( plainPassword, salt );
    }

    public boolean isPasswordValid( String plainPassword ){
        return BCrypt.checkpw( plainPassword, password );
    }

    public UserStatus getStatus(){
        return status;
    }

    public void setStatus( UserStatus status ){
        this.status = status;
    }
}
