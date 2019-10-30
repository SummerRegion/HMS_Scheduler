/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.models.gn;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name="GNCODE")
public class Codes implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "GNCODE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqSetup")
    @SequenceGenerator(name="seqSetup", sequenceName="SQ_SETUP_SEQUENCE", allocationSize=1)
    private Long id;
    
    @Column(name = "CODE", length=20, nullable=false)
    private String code;
    
    @Column(name = "CODE_DESCRIPTION", length=100, nullable=false)
    private String description;

    @Column(name = "SYSTEM_IND", length=1)
    private String systemInd;
    
    @OneToMany(mappedBy="codes", fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    Set<CodeLines> codeLines;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSystemInd() {
        return systemInd;
    }

    public void setSystemInd(String systemInd) {
        this.systemInd = systemInd;
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
        if (!(object instanceof Codes)) {
            return false;
        }
        Codes other = (Codes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.Code[ id=" + id + " ]";
    }
    
}
