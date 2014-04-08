package com.NDWS.common.beans;

import com.sun.istack.internal.NotNull;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/7/14
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewUser {

    @NotNull @Min(5) @Max(50)
    private String username;

    @NotNull @Min(5) @Max(50)
    private String password;

    @NotNull @Min(5) @Max(50)
    private String confirmPassword;

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
}
