package com.NDWS.common.beans;

import com.NDWS.common.Constraints.UsernameUniqueConstraint;

import javax.persistence.*;
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
    @Id
    @Column(name="NDWS_USER_ID",nullable = false)
    private int ndwsUserId;

    @Size(min=1, max=50)
    @Column(name="FIRST_NAME",nullable = false)
    private String firstName;

    @Size(min=1, max=50)
    @Column(name="LAST_NAME",nullable = false)
    private String lastName;

    @Size(min=5, max=50)
    @Column(name="USERNAME", nullable = false)
    @UsernameUniqueConstraint
    private String username;

    public UserProfile(String firstName, String lastName, String username){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

/*    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ndwsUserId")
    User user;*/

    public UserProfile(){
        //default constructor
    }

    public int getNdwsUserId() {
        return ndwsUserId;
    }

    public void setNdwsUserId(int ndwsUserId) {
        this.ndwsUserId = ndwsUserId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
