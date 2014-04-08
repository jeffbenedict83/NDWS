package com.NDWS.common.beans;

import com.NDWS.common.Constraints.FieldMatch;
import com.NDWS.common.Constraints.Username;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/7/14
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 */
@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", errorMessage = "The password fields must match")
})
@Entity
@Table(name="NDWS_USER")
public class NewUser {

    private int id;

    @Size(min=5, max=50)
    @Username
    private String username;

    @Size(min=5, max=50)
    private String password;

    @Size(min=5, max=50)
    private String confirmPassword;

    private boolean enabled = true;

    public NewUser(String username, String password, String confirmPassword){
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public NewUser(){
        //Default Constructor
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
