package com.NDWS.common.beans;

import com.NDWS.common.Constraints.UsernameUniqueConstraint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/9/14
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="NDWS_USER_DATING_PROFILE")
public class UserDatingProfile {
    @Id
    @Column(name="NDWS_USER_ID",nullable = false)
    private int ndwsUserId;

    @Size(min=1, max=50)
    @Column(name="GENDER",nullable = false)
    private String gender;

    @Size(min=1, max=50)
    @Column(name="GENDER_INTEREST",nullable = false)
    private String genderInterest;

    @Size(min=1, max=50)
    @Column(name="AGE",nullable = false)
    private String age;

    @Size(min=1, max=50)
    @Column(name="AGE_INTEREST",nullable = false)
    private String ageInterest;

    @Size(min=1, max=120)
    @Column(name="SHORT_DESCRIPTION", nullable = false)
    private String shortDescription;

    public UserDatingProfile(String gender, String genderInterest, String age, String ageInterest, String shortDescription){
        this.gender = gender;
        this.genderInterest = genderInterest;
        this.age = age;
        this.ageInterest = ageInterest;
        this.shortDescription = shortDescription;
    }

    public UserDatingProfile(){
        //default constructor
    }

    public int getNdwsUserId() {
        return ndwsUserId;
    }

    public void setNdwsUserId(int ndwsUserId) {
        this.ndwsUserId = ndwsUserId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGenderInterest() {
        return genderInterest;
    }

    public void setGenderInterest(String genderInterest) {
        this.genderInterest = genderInterest;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAgeInterest() {
        return ageInterest;
    }

    public void setAgeInterest(String ageInterest) {
        this.ageInterest = ageInterest;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
