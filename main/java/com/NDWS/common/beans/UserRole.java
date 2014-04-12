package com.NDWS.common.beans;

import com.NDWS.common.Constraints.Username;

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
@Table(name = "NDWS_USER_ROLES")
public class UserRole {
    @Id
    @Column(name="NDWS_USER_ID")
    private int ndwsUserId;

    @Column(name="AUTHORITY",nullable = false)
    private String authority;


    public UserRole(int ndwsUserId, String authority){
        this.ndwsUserId = ndwsUserId;
        this.authority = authority;
    }

    public UserRole(){
        //Default Constructor
    }

    public int getNdwsUserId() {
        return ndwsUserId;
    }

    public void setNdwsUserId(int ndwsUserId) {
        this.ndwsUserId = ndwsUserId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
