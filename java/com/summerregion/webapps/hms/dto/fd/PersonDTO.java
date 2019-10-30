/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.dto.fd;

import com.summerregion.webapps.hms.dto.gn.UserDTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long personId;
    private String title;
    private String titleDesc;
    private String name;
    private String idNo;
    private String idType;
    private String idTypeDesc;
    private String gender;
    private String genderDesc;
    private Date dateOfBirth;
    private String vehicleNo;
    private String emailAddress;
    private String mobilePhone;
    private String homePhone;
    private String officePhone;
    private String faxNo;
    private String vipInd;
    private String blacklistInd;
    private String skipperInd;
    private String billTo;
    private String preference;
    private Date issueDate;
    private String issuePlace;
    private String occupation;
    private String nationality;
    private String nationalityDesc;
    private String remarks;
    
    private Long alternateId;
    
    private Date enteredDatetime;
    private String activeInd;
    private UserDTO enteredBy;
    private Long version;
    
    public Long getVersion() {
        return version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
    public PersonDTO() {};
    
    public PersonDTO(Long personId, String name) {
        this.personId = personId;
        this.name = name;
    }
    
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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

    public Long getAlternateId() {
        return alternateId;
    }

    public void setAlternateId(Long alternateId) {
        this.alternateId = alternateId;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }

    public UserDTO getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(UserDTO enteredBy) {
        this.enteredBy = enteredBy;
    }

    public Date getEnteredDatetime() {
        return enteredDatetime;
    }

    public void setEnteredDatetime(Date enteredDatetime) {
        this.enteredDatetime = enteredDatetime;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonDTO)) {
            return false;
        }
        PersonDTO other = (PersonDTO) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.dto.PersonDTO[ id=" + personId + " ]";
    }
    
}
