/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.models.gn;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "GNPARAMETER")
@NamedQueries({
    @NamedQuery(name = "Parameter.findParameter", query = "SELECT p FROM Parameter p WHERE p.parameterCode = :parameterCode"),
    @NamedQuery(name = "Parameter.findParameterValue", query = "SELECT p.parameterValue FROM Parameter p WHERE p.parameterCode = :parameterCode")
    })
public class Parameter implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PARAMETER_CODE",length=60, nullable=false)
    private String parameterCode;
    
    @Size(max = 12)
    @Column(name = "PARAMETER_CAT",length=12,columnDefinition="DEFAULT 'SYS'")
    private String parameterCat;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "VALUE",length=250, nullable=false)
    private String parameterValue;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "PARAMETER_DESC",length=600, nullable=false)
    private String parameterDesc;
    
    @Size(max = 12)
    @Column(name = "MODULE",length=12)
    private String parameterModule;
    
    @Size(max = 60)
    @Column(name = "PARAMETER_RANGE",length=60)
    private String parameterRange;
    
    @Size(max = 1)
    @Column(name = "ACTIVE_IND",length=1,columnDefinition="CHAR(1) DEFAULT 'Y'")
    private String activeInd;
    
    @Version
    @Column(name = "SYNC_VER",nullable = false)
    private Long version;
    
    public Long getVersion() {
        return version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
    public Parameter() {}

    public Parameter(String parameterCode, String parameterValue, String parameterDesc) {
        this.parameterCode = parameterCode;
        this.parameterValue = parameterValue;
        this.parameterDesc = parameterDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parameterCode != null ? parameterCode.hashCode() : 0);
        hash += (parameterValue != null ? parameterValue.hashCode() : 0);
        hash += (parameterDesc != null ? parameterDesc.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parameter)) {
            return false;
        }
        
        Parameter other = (Parameter) object;
        if ((this.parameterCode == null && other.parameterCode != null) || 
                (this.parameterCode != null && !this.parameterCode.equals(other.parameterCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.gn.Parameter[ parameterCode=" + parameterCode + " ]";
    }

    public String getParameterCode() {
        return parameterCode;
    }

    public void setParameterCode(String parameterCode) {
        this.parameterCode = parameterCode;
    }

    public String getParameterCat() {
        return parameterCat;
    }

    public void setParameterCat(String parameterCat) {
        this.parameterCat = parameterCat;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public String getParameterDesc() {
        return parameterDesc;
    }

    public void setParameterDesc(String parameterDesc) {
        this.parameterDesc = parameterDesc;
    }

    public String getParameterModule() {
        return parameterModule;
    }

    public void setParameterModule(String parameterModule) {
        this.parameterModule = parameterModule;
    }

    public String getParameterRange() {
        return parameterRange;
    }

    public void setParameterRange(String parameterRange) {
        this.parameterRange = parameterRange;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }
    
}
