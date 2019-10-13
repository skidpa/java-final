package se.experis.model;

import org.springframework.data.util.Lazy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name", nullable = false, unique = true)
    //@NotBlank(message = "not blank")
    private String userName;

    @Column(name = "user_password", nullable = false)
    //@NotBlank(message = "not blank")
    private String userPassword;

    @Column(name = "user_email", nullable = false, unique = true)
    //@NotBlank(message = "not blank")
    private String userEmail;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Characters> characters;

    public Users() {
        id = 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Characters> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Characters> characters) {
        this.characters = characters;
    }
}
