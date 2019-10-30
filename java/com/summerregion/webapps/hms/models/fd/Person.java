/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.models.fd;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Formula;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "FDPERSON")
@NamedQueries ({
  @NamedQuery(name="queryByPersonId", query="SELECT p FROM Person p WHERE p.personId=:personId")
})

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FDPERSON_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="seqGlobal")
    @SequenceGenerator(name="seqGlobal", sequenceName="SQ_GLOBAL_SEQUENCE", allocationSize=1)
    private Long personId;
    @Column(name = "PERSON_NO", length=20)
    private String personNo;
    @Column(name = "TITLE", length=20)
    private String title;
    @Formula(" FN_GETCODEDESC('TTL', TITLE) ")
    private String titleDesc;
    @Column(name = "NAME", length=100, nullable=false)
    private String name;
    @Column(name = "ID_NO", length=35)
    private String idNo;
    @Column(name = "ID_TYPE", length=20)
    private String idType;
    @Formula(" FN_GETCODEDESC('IDT', ID_TYPE) ")
    private String idTypeDesc;
    @Column(name = "GENDER", length=20)
    private String gender;
    @Formula(" FN_GETCODEDESC('SEX', GENDER) ")
    private String genderDesc;
    @Column(name = "DATE_OF_BIRTH", length=100)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "VEHICLE_NO", length=20)
    private String vehicleNo;
    @Column(name = "EMAIL_ADDR", length=60)
    private String emailAddress;
    @Column(name = "MOBILE_PHONE", length=40)
    private String mobilePhone;
    @Column(name = "HOME_PHONE", length=40)
    private String homePhone;
    @Column(name = "OFFICE_PHONE", length=40)
    private String officePhone;
    @Column(name = "FAX_NO", length=40)
    private String faxNo;
    @Column(name = "VIP_IND", length=1)
    private String vipInd;
    @Column(name = "BLACKLIST_IND", length=1)
    private String blacklistInd;
    @Column(name = "SKIPPER_IND", length=1)
    private String skipperInd;
    @Column(name = "BILL_TO", length=1)
    private String billTo;
    @Column(name = "PREFERENCE", length=500)
    private String preference;
    @Column(name = "ISSUE_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date issueDate;
    @Column(name = "ISSUE_PLACE", length=100)
    private String issuePlace;
    @Column(name = "OCCUPATION", length=100)
    private String occupation;
    @Column(name = "NATIONALITY", length=20)
    private String nationality;
    @Formula(" FN_GETCODEDESC('NAT', NATIONALITY) ")
    private String nationalityDesc;
    @Column(name = "REMARKS", length=2000)
    private String remarks;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ALTERNATE_FDPERSON_ID", referencedColumnName = "FDPERSON_ID")
    private Person alternatePerson;
    
    public Person() {};
    
    public Person(Long personId, String name) {
        this.personId = personId;
        this.name = name;
    }
    
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonNo() {
        return personNo;
    }

    public void setPersonNo(String personNo) {
        this.personNo = personNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getVipInd() {
        return vipInd;
    }

    public void setVipInd(String vipInd) {
        this.vipInd = vipInd;
    }

    public String getBlacklistInd() {
        return blacklistInd;
    }

    public void setBlacklistInd(String blacklistInd) {
        this.blacklistInd = blacklistInd;
    }

    public String getSkipperInd() {
        return skipperInd;
    }

    public void setSkipperInd(String skipperInd) {
        this.skipperInd = skipperInd;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationalityDesc() {
        return nationalityDesc;
    }

    public void setNationalityDesc(String nationalityDesc) {
        this.nationalityDesc = nationalityDesc;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTitleDesc() {
        return titleDesc;
    }

    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc;
    }
    
    public String getIdTypeDesc() {
        return idTypeDesc;
    }
    
    public void setIdTypeDesc(String idTypeDesc) {
        this.idTypeDesc = idTypeDesc;
    }
    
    public String getGenderDesc() {
        return genderDesc;
    }
    
    public void setGenderDesc(String genderDesc) {
        this.genderDesc = genderDesc;
    }

    public Person getAlternatePerson() {
        return alternatePerson;
    }

    public void setAlternatePerson(Person alternatePerson) {
        this.alternatePerson = alternatePerson;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.Person[ id=" + personId + " ]";
    }
}
