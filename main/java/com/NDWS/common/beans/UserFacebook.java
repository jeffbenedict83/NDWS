package com.NDWS.common.beans;

import com.NDWS.common.Constraints.FacebookUsernameUniqueConstraint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/14/14
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "NDWS_USER_FACEBOOK")
public class UserFacebook {

    @Id
    @Column(name="NDWS_USER_ID",nullable = false)
    private int ndwsUserId;

    @Column(name="NDWS_USER_FACEBOOK_USERNAME",nullable = false)
    @Size(min=5, max=50)
    @FacebookUsernameUniqueConstrainttest
    String facebookUsername;

    @Column(name="NDWS_USER_FACEBOOK_PASSWORD",nullable = false)
    @Size(min=5, max=50)
    String facebookPassword;

    public UserFacebook(){
        //default constructor;
    }

    public UserFacebook(String facebookUsername, String facebookPassword){
        this.facebookUsername = facebookUsername;
        this.facebookPassword = facebookPassword;
    }

    public int getNdwsUserId() {
        return ndwsUserId;
    }

    public void setNdwsUserId(int ndwsUserId) {
        this.ndwsUserId = ndwsUserId;
    }

    public String getFacebookUsername() {
        return facebookUsername;
    }

    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    public String getFacebookPassword() {
        return facebookPassword;
    }

    public void setFacebookPassword(String facebookPassword) {
        this.facebookPassword = facebookPassword;
    }
}
