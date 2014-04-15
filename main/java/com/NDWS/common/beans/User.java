package com.NDWS.common.beans;

import com.NDWS.common.Constraints.EmailUniqueConstraint;
import com.NDWS.common.Constraints.FieldMatch;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.*;

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
@Table(name = "NDWS_USER")
public class User {
    @Id
    @Column(name="ID")
    private int id;

    @Column(name="EMAIL_ADDRESS",nullable = false)
    @Size(min=5, max=50)
    @Email
    @EmailUniqueConstraint
    private String emailAddress;

    @Column(name="PASSWORD",nullable = false)
    @Size(min=5, max=50)
    private String password;

    @Size(min=5, max=50)
    private String confirmPassword;

    @Column(name="ENABLED", nullable = false)
    private boolean enabled = true;


/*    @OneToOne(fetch =  FetchType.LAZY, mappedBy="user")
    private UserProfile userProfile;*/

    public User(String emailAddress, String password, String confirmPassword){
        this.emailAddress = emailAddress;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public User(){
        //Default Constructor
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

/*    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }*/
}
