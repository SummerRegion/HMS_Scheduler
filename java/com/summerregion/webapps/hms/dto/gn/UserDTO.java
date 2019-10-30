/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.dto.gn;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Faizul (zulcomp) Ngsrimin
 */
public class UserDTO {
    
    private Long id;
    
    @NotNull
    @Size(max=20)
    private String userId;

    @Size(max=100)
    private String userName;

    @NotNull
    @Size(max=200)
    private String userPassword;

    private String activeInd;
    
    private boolean useDefPwd;
    
    private boolean hasPwd;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }

    public boolean isUseDefPwd() {
        return useDefPwd;
    }

    public void setUseDefPwd(boolean useDefPwd) {
        this.useDefPwd = useDefPwd;
    }

    public boolean isHasPwd() {
        return hasPwd;
    }

    public void setHasPwd(boolean hasPwd) {
        this.hasPwd = hasPwd;
    }
    
    
}
