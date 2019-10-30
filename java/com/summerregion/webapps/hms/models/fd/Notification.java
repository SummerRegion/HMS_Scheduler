/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.models.fd;

import com.summerregion.webapps.hms.models.gn.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Faizul (zulcomp) Ngsrimin
 */
@Entity
@Table(name="FDNOTIFICATION")
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "FDNOTIFICATION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seqGlobal")
    @SequenceGenerator(name="seqGlobal", sequenceName="SQ_GLOBAL_SEQUENCE", allocationSize=1)
    private Long notificationId;

    @Column(name = "TITLE", length=200)
    private String title;
    
    @Column(name = "MESSAGE", length=1000)
    private String message;
    
    @Column(name = "ICON_NAME",length=80)
    private String iconName;
    
    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMesssage(String messsage) {
        this.message = messsage;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationId != null ? notificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.notificationId == null && other.notificationId != null) || (this.notificationId != null && !this.notificationId.equals(other.notificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.fd.Notification[ notificationId=" + notificationId + " ]";
    }
}
