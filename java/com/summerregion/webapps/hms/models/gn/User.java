/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.models.gn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.validation.constraints.Size;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name="GNUSER")
@NamedQueries ({
  @NamedQuery(name="allActiveUser", query="SELECT u FROM User u WHERE u.activeInd = 'Y'"),
  @NamedQuery(name="queryByUserId", query="SELECT u FROM User u WHERE u.userId=:uId"),
  @NamedQuery(name="tryLoginQuery", query="SELECT a FROM User a WHERE UPPER(a.userId) = :usr AND a.password = function('Fn_Pwdencryption',:pwd)")
})

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "GNUSER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqSetup")
    @SequenceGenerator(name="seqSetup", sequenceName="SQ_SETUP_SEQUENCE", allocationSize=1)
    private Long id;
    
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name="GNUSERROLE", joinColumns = @JoinColumn(name = "GNUSER_ID"), inverseJoinColumns = @JoinColumn(name = "GNROLE_ID"))
//    private List<Role> roles = new ArrayList<>();
    
    @Column(name="USER_ID",length=20, nullable=false)
    private String userId;
    
    @Column(name="USER_NAME",length=100, nullable=false)
    private String userName;
    
    @Column(name="PASSWORD",length=500, nullable=false)
    private String password;
    
    @Column(name="PASSWORD_UPDATED_DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date passwordUpdatedDatetime;
    
    @Column(name="SALT",length=70)
    private String salt;
    
    @Column(name = "ENTERED_BY",nullable=false)
    private Long enteredBy;
    
    @Column(name="ENTERED_DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date enteredDatetime;
    
    @Column(name = "LAST_UPDATED_BY")
    private Long lastUpdatedBy;
    
    @Column(name="LAST_UPDATED_DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lastUpdatedDatetime;
    
    @Column(name = "PREV_UPDATED_BY")
    private Long prevUpdatedBy;
    
    @Column(name="PREV_UPDATED_DATETIME")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date prevUpdatedDatetime;
    
    @Size(min = 1, max = 1)
    @Column(name = "ACTIVE_IND", length=1)
    private String activeInd;

    @Version
    @Column(name = "SYNC_VER")
    private Long version;
    
    public Long getVersion() {
        return version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
//    public List<Role> getRole() {
//        return roles;
//    }
//
//    public void setRole(List<Role> role) {
//        this.roles = role;
//    }
    
    public User() {}
    
    public User(Long id, String userId, String userName, String password) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
        
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

    public Date getPasswordUpdatedDatetime() {
        return passwordUpdatedDatetime;
    }

    public void setPasswordUpdatedDatetime(Date passwordUpdatedDatetime) {
        this.passwordUpdatedDatetime = passwordUpdatedDatetime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }

    public Long getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(Long enteredBy) {
        this.enteredBy = enteredBy;
    }

    public Date getEnteredDatetime() {
        return enteredDatetime;
    }

    public void setEnteredDatetime(Date enteredDatetime) {
        this.enteredDatetime = enteredDatetime;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDatetime() {
        return lastUpdatedDatetime;
    }

    public void setLastUpdatedDatetime(Date lastUpdatedDatetime) {
        this.lastUpdatedDatetime = lastUpdatedDatetime;
    }

    public Long getPrevUpdatedBy() {
        return prevUpdatedBy;
    }

    public void setPrevUpdatedBy(Long prevUpdatedBy) {
        this.prevUpdatedBy = prevUpdatedBy;
    }

    public Date getPrevUpdatedDatetime() {
        return prevUpdatedDatetime;
    }

    public void setPrevUpdatedDatetime(Date prevUpdatedDatetime) {
        this.prevUpdatedDatetime = prevUpdatedDatetime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (userId != null ? userId.hashCode() : 0);
        hash += (userName != null ? userName.hashCode() : 0);
        hash += (password != null ? password.hashCode() : 0);
        
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.User[ id=" + id + " ]";
    }

}
