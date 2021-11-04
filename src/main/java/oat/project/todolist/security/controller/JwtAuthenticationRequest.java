package oat.project.todolist.security.controller;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by stephan on 20.03.16.
 */
public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;
    private String email;
    private String sex;
    private String firstname;
    private String lastname;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private String hometown;
    private Date dateOfBirth;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username, String password, String email, String sex, String firstname, String lastname, String hometown, Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hometown = hometown;
        this.dateOfBirth = dateOfBirth;
    }
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}
