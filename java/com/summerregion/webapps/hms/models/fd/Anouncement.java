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
@Table(name="FDANOUNCEMENT")
public class Anouncement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "FDANOUNCEMENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seqGlobal")
    @SequenceGenerator(name="seqGlobal", sequenceName="SQ_GLOBAL_SEQUENCE", allocationSize=1)
    private Long id;
    
    @Column(name="URL", length=500)
    private String url;
    @Column(name="MESSSAGE",length=1000)
    private String message;
    @Column(name="MESSAGE_TYPE", length=20)
    private String messageType;
    @Column(name="ITEM", length=1000)
    private String item;
    @Column(name="ITEM_TYPE", length=20)
    private String itemType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anouncement)) {
            return false;
        }
        Anouncement other = (Anouncement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.fd.Anouncement[ id=" + id + " ]";
    }
}
