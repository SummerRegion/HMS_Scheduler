/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.models.gn;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "GNHOTEL")
@org.hibernate.annotations.Table(appliesTo = "GNHOTEL")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "GNHOTEL_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqSetup")
    @SequenceGenerator(name="seqSetup", sequenceName="SQ_SETUP_SEQUENCE", allocationSize=1)
    private Long hotelId;
    
    @Size(max = 10)
    @Column(name = "HOTEL_CODE", length=10)
    private String hotelCode;
    
    @Size(max = 100)
    @Column(name = "HOTEL_NAME", length=100)
    private String hotelName;
    
    @Size(max = 20)
    @Column(name = "GST_NO", length=20)
    private String gstNo;

    @Size(max = 20)
    @Column(name = "SST_NO", length=20)
    private String sstNo;
    
    @Size(max = 40)
    @Column(name = "PHONE_NO", length=40)
    private String phoneNo;
    
    @Size(max = 40)
    @Column(name = "FAX_NO", length=40)
    private String faxNo;
    
    @Size(max = 60)
    @Column(name = "WEBSITE", length=60)
    private String website;
    
    @Size(max = 60)
    @Column(name = "EMAIL", length=60)
    private String email;
    
    @Size(max = 2000)
    @Column(name = "ADDRESS", length=2000)
    private String address;
    
    @Size(max = 20)
    @Column(name = "REGISTRATION_NO", length=20)
    private String registrationNo;
    
    @Lob
    @Column(name = "LOGO")
    private byte[] logo;
    
    @Lob
    @Column(name = "BACKGROUND")
    private byte[] background;
    
    @Size(max = 20)
    @Column(name = "CUT_OFF_TIME", length=20)
    private String cutOffTime;
    
    @Size(max = 20)
    @Column(name = "CHECK_IN_TIME", length=20)
    private String checkInTime;
    
    @Size(max = 20)
    @Column(name = "CHECK_OUT_TIME", length=20)
    private String checkOutTime;
    
    @Column(name = "KEY_CARD",precision=5, scale=0)
    private Integer keyCard;
    
    @Size(max = 100)
    @Column(name = "TOURISM_TAX_EXEMPTION", length=100)
    private String tourismTaxExemption;
    
    @Column(name = "MAX_COUNTER",precision=5, scale=0)
    private Integer maxCounter;
    
    @Column(name = "MAX_RESERVE_COUNT_DAYS",precision=5, scale=0)
    private Integer maxReserveCountDays;
    
    @Column(name = "MAX_RESERVE_LIST_DAYS",precision=5, scale=0)
    private Integer maxReserveListDays;
    
    @Size(max = 20)
    @Column(name = "ACTIVITY_START_TIME", length=20)
    private String activityStartTime;
    
    @Column(name = "ACTIVITY_ENQUIRY_DAYS",precision=5, scale=0)
    private Integer activityEnquiryDays;
    
    @Column(name = "EVENT_ENQUIRY_DAYS",precision=5, scale=0)
    private Integer eventEnquiryDays;
    
    @Size(max = 100)
    @Column(name = "WEEKENDS", length=100)
    private String weekend;
    
    public Hotel() {}
    
    public Hotel(Long hotelId){
        this.hotelId = hotelId; //only mandotory columns
        this.hotelCode = hotelCode;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelId != null ? hotelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.hotelId == null && other.hotelId != null) || (this.hotelId != null && !this.hotelId.equals(other.hotelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.gn.Hotel[ id=" + hotelId + " ]";
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public byte[] getBackground() {
        return background;
    }

    public void setBackground(byte[] background) {
        this.background = background;
    }

    public String getCutOffTime() {
        return cutOffTime;
    }

    public void setCutOffTime(String cutOffTime) {
        this.cutOffTime = cutOffTime;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Integer getKeyCard() {
        return keyCard;
    }

    public void setKeyCard(Integer keyCard) {
        this.keyCard = keyCard;
    }

    public String getTourismTaxExemption() {
        return tourismTaxExemption;
    }

    public void setTourismTaxExemption(String tourismTaxExemption) {
        this.tourismTaxExemption = tourismTaxExemption;
    }

    public Integer getMaxCounter() {
        return maxCounter;
    }

    public void setMaxCounter(Integer maxCounter) {
        this.maxCounter = maxCounter;
    }

    public Integer getMaxReserveCountDays() {
        return maxReserveCountDays;
    }

    public void setMaxReserveCountDays(Integer maxReserveCountDays) {
        this.maxReserveCountDays = maxReserveCountDays;
    }

    public Integer getMaxReserveListDays() {
        return maxReserveListDays;
    }

    public void setMaxReserveListDays(Integer maxReserveListDays) {
        this.maxReserveListDays = maxReserveListDays;
    }

    public Integer getActivityEnquiryDays() {
        return activityEnquiryDays;
    }

    public void setActivityEnquiryDays(Integer activityEnquiryDays) {
        this.activityEnquiryDays = activityEnquiryDays;
    }

    public Integer getEventEnquiryDays() {
        return eventEnquiryDays;
    }

    public void setEventEnquiryDays(Integer eventEnquiryDays) {
        this.eventEnquiryDays = eventEnquiryDays;
    }

    
    public String getSstNo() {
        return sstNo;
    }

    public void setSstNo(String sstNo) {
        this.sstNo = sstNo;
    }
    
    public String getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(String activityStartTime) {
        this.activityStartTime = activityStartTime;
    }
    
    public String getWeekend() {
        return weekend;
    }

    public void setWeekend(String weekend) {
        this.weekend = weekend;
    }
}
