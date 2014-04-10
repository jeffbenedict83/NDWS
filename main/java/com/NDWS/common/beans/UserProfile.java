package com.NDWS.common.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/9/14
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="NDWS_USER_PROFILE")
public class UserProfile {
    //from the User Class
    private Integer userId;
    private User user;

    @Size(min=1, max=50)
    private String firstName;

    @Size(min=1, max=50)
    private String lastName;

    public UserProfile(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserProfile(){
        //default constructor
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
