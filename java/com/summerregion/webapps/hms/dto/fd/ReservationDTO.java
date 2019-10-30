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
 * @author Faizul
 */
public class ReservationDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;

    private String reservationNumber;
    
    private PersonDTO bookingPerson;
    
    private PersonDTO guestPerson;
    
    private Date arrivalDate;

    private Date departureDate;
    
    private String contactPerson;
    private String contactNumber;
    private String emailAddress;
    private String fax;

    private String unit;

    private String reservationSource;
    private String reservationSourceDesc;

    private String segments;
    private String segmentsDesc;
    
    private String reservationStatus;
    private String reservationStatusDesc;
    
    private String reservationType;
    private String reservationTypeDesc;

    private String groupInd;
    private String groupName;
    
    private String bankName;
    private String creditCardNumber;
    private String expiryDate;
    private String approvalCode;
    private String billingInstruction;
    private String waitingListInd;
    private Integer numOfRoom;
    
    private String eventInd;
    
    private String remarks;
    
    private String bookingNo;

    private List<RegistrationDTO> registrationList;
    private RegistrationDTO registration;
    private String activeInd;
    private UserDTO enteredBy;
    private Date enteredDatetime;
    private Long totalNumOfNight;
    private Long version;
    
    public Long getVersion() {
        return version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public PersonDTO getBookingPerson() {
        return bookingPerson;
    }

    public void setBookingPerson(PersonDTO bookingPerson) {
        this.bookingPerson = bookingPerson;
    }

    public PersonDTO getGuestPerson() {
        return guestPerson;
    }

    public void setGuestPerson(PersonDTO guestPerson) {
        this.guestPerson = guestPerson;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReservationSource() {
        return reservationSource;
    }

    public void setReservationSource(String reservationSource) {
        this.reservationSource = reservationSource;
    }

    public String getReservationSourceDesc() {
        return reservationSourceDesc;
    }

    public void setReservationSourceDesc(String reservationSourceDesc) {
        this.reservationSourceDesc = reservationSourceDesc;
    }

    public String getSegments() {
        return segments;
    }

    public void setSegments(String segments) {
        this.segments = segments;
    }

    public String getSegmentsDesc() {
        return segmentsDesc;
    }

    public void setSegmentsDesc(String segmentsDesc) {
        this.segmentsDesc = segmentsDesc;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getReservationStatusDesc() {
        return reservationStatusDesc;
    }

    public void setReservationStatusDesc(String reservationStatusDesc) {
        this.reservationStatusDesc = reservationStatusDesc;
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public String getReservationTypeDesc() {
        return reservationTypeDesc;
    }

    public void setReservationTypeDesc(String reservationTypeDesc) {
        this.reservationTypeDesc = reservationTypeDesc;
    }

    public String getGroupInd() {
        return groupInd;
    }

    public void setGroupInd(String groupInd) {
        this.groupInd = groupInd;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getBillingInstruction() {
        return billingInstruction;
    }

    public void setBillingInstruction(String billingInstruction) {
        this.billingInstruction = billingInstruction;
    }

    public String getWaitingListInd() {
        return waitingListInd;
    }

    public void setWaitingListInd(String waitingListInd) {
        this.waitingListInd = waitingListInd;
    }

    public Integer getNumOfRoom() {
        return numOfRoom;
    }

    public void setNumOfRoom(Integer numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    public String getEventInd() {
        return eventInd;
    }

    public void setEventInd(String eventInd) {
        this.eventInd = eventInd;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
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

    public Long getTotalNumOfNight() {
        return totalNumOfNight;
    }

    public void setTotalNumOfNight(Long totalNumOfNight) {
        this.totalNumOfNight = totalNumOfNight;
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
        if (!(object instanceof ReservationDTO)) {
            return false;
        }
        ReservationDTO other = (ReservationDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.dto.fd.ReservationDTO[ id=" + id + " ]";
    }

    public List<RegistrationDTO> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<RegistrationDTO> registrationList) {
        this.registrationList = registrationList;
    }

    public RegistrationDTO getRegistration() {
        return registration;
    }

    public void setRegistration(RegistrationDTO registration) {
        this.registration = registration;
    }
    
    
}
