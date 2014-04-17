package com.NDWS.common.beans;

import com.NDWS.common.Constraints.EmailUniqueConstraint;
import com.NDWS.common.Constraints.FieldMatch;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/7/14
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "NDWS_USER_FACEBOOK_PROFILE_PHOTO")
public class UserFacebookProfilePhoto {
    @Id
    @Column(name="ID")
    private int id;

    @Column(name="NDWS_USER_ID",nullable = false)
    private int ndwsUserId;

    @Column(name="FACEBOOK_PROFILE_PHOTO_PATH",nullable = false)
    @Size(min=5, max=200)
    private String facebookProfilePhotoPath;

    @Column(name="visibility", nullable = false)
    private int visibility;

    public UserFacebookProfilePhoto(int ndwsUserId, String facebookProfilePhotoPath, int visibility){
        this.ndwsUserId = ndwsUserId;
        this.facebookProfilePhotoPath = facebookProfilePhotoPath;
        this.visibility = visibility;
    }

    public UserFacebookProfilePhoto(){
        //Default Constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNdwsUserId() {
        return ndwsUserId;
    }

    public void setNdwsUserId(int ndwsUserId) {
        this.ndwsUserId = ndwsUserId;
    }

    public String getFacebookProfilePhotoPath() {
        return facebookProfilePhotoPath;
    }

    public void setFacebookProfilePhotoPath(String facebookProfilePhotoPath) {
        this.facebookProfilePhotoPath = facebookProfilePhotoPath;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
}
