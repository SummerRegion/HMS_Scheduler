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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name="GNROLE")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "GNROLE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqSetup")
    @SequenceGenerator(name="seqSetup", sequenceName="SQ_SETUP_SEQUENCE", allocationSize=1)
    private Long gnroleid;

    @Size(max = 100)
    @Column(name = "ROLE_NAME",length=100)
    private String rolename; 
    @Size(max = 100)
    @Column(name = "ROLE_DESC",length=100)
    private String roledesc; 
    
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
    
    public List<User> getPosts() {
        return users;
    }

    public void setPosts(List<User> posts) {
        this.users = posts;
    }
    
    public Long getGnroleid() {
        return gnroleid;
    }

    public void setGnroleid(Long gnroleid) {
        this.gnroleid = gnroleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gnroleid != null ? gnroleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.gnroleid == null && other.gnroleid != null) || (this.gnroleid != null && !this.gnroleid.equals(other.gnroleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.gn.Role[ id=" + gnroleid + " ]";
    }
    
}
