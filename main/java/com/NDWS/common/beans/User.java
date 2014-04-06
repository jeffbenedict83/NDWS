package com.NDWS.common.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/5/14
 * Time: 11:44 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="USER")
public class User {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public User() {

    }

    public User(Long id, String firstname, String lastname, String username, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;

    }

    private void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    private void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getFirstname(){
        return firstname;
    }

    private void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getLastname(){
        return lastname;
    }

    private void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    private void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}