/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.models.gn;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name="GNCODELINE")
@NamedQueries({
    @NamedQuery(name="retrieveCodeLinesByCode", 
      query="SELECT cl FROM CodeLines cl JOIN FETCH cl.codes cd WHERE cl.codes.code = :cdCode ORDER BY cl.sequenceNo, cl.description"),
    @NamedQuery(name="retrieveCodeLines", 
            query="SELECT cl FROM CodeLines cl JOIN FETCH cl.codes cd WHERE cl.code = :clCode AND cd.code = :cdCode")
})
public class CodeLines implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "GNCODELINE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqSetup")
    @SequenceGenerator(name="seqSetup", sequenceName="SQ_SETUP_SEQUENCE", allocationSize=1)
    private Long id;

    @Column(name = "CODE", length=20, nullable=false)
    private String code;
    
    @Column(name = "CODE_DESCRIPTION", length=100, nullable=false)
    private String description;

    @Column(name = "SYSTEM_IND", length=1)
    private String systemInd;
    
    @Column(name = "DEFAULT_IND", length=1)
    private String defaultInd;
    
    @Column(name = "SEQUENCE_NO")
    private Integer sequenceNo;
    
    @OneToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name="GNCODE_ID", referencedColumnName="GNCODE_ID")
    Codes codes;
    
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

    public String getDefaultInd() {
        return defaultInd;
    }

    public void setDefaultInd(String defaultInd) {
        this.defaultInd = defaultInd;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Codes getCodes() {
        return codes;
    }

    public void setCodes(Codes codes) {
        this.codes = codes;
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
        if (!(object instanceof CodeLines)) {
            return false;
        }
        CodeLines other = (CodeLines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.CodeLines[ id=" + id + " ]";
    }
    
}
