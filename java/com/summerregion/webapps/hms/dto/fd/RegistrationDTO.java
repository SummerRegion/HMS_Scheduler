/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.dto.fd;

import com.summerregion.webapps.hms.dto.gn.RoomDTO;
import com.summerregion.webapps.hms.dto.gn.UserDTO;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Faizul
 */
public class RegistrationDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;

    private ReservationDTO reservation;

    private String registrationNumber;
    private String registrationStatus;
    private String registrationStatusDesc;

    private PersonDTO person;

    private String principalInd;    
    
    private RegistrationDTO parentRegistration;
    
    private Date arrivalDate;

    private Date departureDate;
    
    private String arrivalTime;
    private String departureTime;
    
    private Integer numOfNight;

    private String occupancyType;
    private String occupancyTypeDesc;

    private Integer numOfAdult;
    private Integer numOfChild;
    
    private String reasonType;
    private String reasonCode;
    private String reasonDescription;
    
    private UserDTO cancelledBy;
    private Date cancelledDatetime;
    private UserDTO reInstateBy;
    private Date reInstateDatetime;
    
    private Double creditCardAmount;
    private String creditCardInd;
    //@Column(name = "GNPAYMENTMODE_ID          NUMBER(38),
    private String bankName;
    private String creditCardNumber;
    private String expiryDate;
    private String approvalCode;

    private String roomType;
    private String roomTypeDesc;
    private String chargeRoomType;

    private Integer numOfKey;

    private Double roomRate;
    private Double chargeRoomRate;
    private RoomDTO room;
    private Double discountAmount;
    private Double discountPercentage;
    private String discountInd;
    private String splitInd;
    private Double splitAmount;
    private Double splitPercentage;
    private String lateCheckOut;
    private Integer numOfExtraBed;
    private Integer numOfCrib;
    private String roomPreference;
    private String specialRequestInd;
    private String estimatedArrivalTime;
    private String estimatedDepartureTime;
    private String pickUpTime;
    private Date checkedInDatetime;
    private Date checkedOutDatetime;
    private Date checkInHotelDate;
    private Date checkOutHotelDate;

    //@Column(name = "CHECKED_IN_BY             NUMBER(38),
    //@Column(name = "CHECKED_OUT_BY            NUMBER(38),
    
    private String walkInInd;
    private String nonGuestInd;
    private String nightAuditInd;
    private String addRoomInd;
    private String selfCheckinInd;
    private String remarks;
    private String activeInd;
    private UserDTO enteredBy;
    private Date enteredDatetime;
    private Double baseRate;
    private Double totalAmount;
    private Double advancePayment;
    private Double totalRoomCharge;
    private Integer numOfBreakfast;
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

    public ReservationDTO getReservation() {
        return reservation;
    }

    public void setReservation(ReservationDTO reservation) {
        this.reservation = reservation;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public String getRegistrationStatusDesc() {
        return registrationStatusDesc;
    }

    public void setRegistrationStatusDesc(String registrationStatusDesc) {
        this.registrationStatusDesc = registrationStatusDesc;
    }

    public PersonDTO getPerson() {
        return person;
    }

    public void setPerson(PersonDTO person) {
        this.person = person;
    }

    public String getPrincipalInd() {
        return principalInd;
    }

    public void setPrincipalInd(String principalInd) {
        this.principalInd = principalInd;
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

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getNumOfNight() {
        return numOfNight;
    }

    public void setNumOfNight(Integer numOfNight) {
        this.numOfNight = numOfNight;
    }

    public String getOccupancyType() {
        return occupancyType;
    }

    public void setOccupancyType(String occupancyType) {
        this.occupancyType = occupancyType;
    }

    public String getOccupancyTypeDesc() {
        return occupancyTypeDesc;
    }

    public void setOccupancyTypeDesc(String occupancyTypeDesc) {
        this.occupancyTypeDesc = occupancyTypeDesc;
    }

    public Integer getNumOfAdult() {
        return numOfAdult;
    }

    public void setNumOfAdult(Integer numOfAdult) {
        this.numOfAdult = numOfAdult;
    }

    public Integer getNumOfChild() {
        return numOfChild;
    }

    public void setNumOfChild(Integer numOfChild) {
        this.numOfChild = numOfChild;
    }

    public String getReasonType() {
        return reasonType;
    }

    public void setReasonType(String reasonType) {
        this.reasonType = reasonType;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonDescription() {
        return reasonDescription;
    }

    public void setReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
    }

    public UserDTO getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(UserDTO cancelledBy) {
        this.cancelledBy = cancelledBy;
    }

    public Date getCancelledDatetime() {
        return cancelledDatetime;
    }

    public void setCancelledDatetime(Date cancelledDatetime) {
        this.cancelledDatetime = cancelledDatetime;
    }

    public UserDTO getReInstateBy() {
        return reInstateBy;
    }

    public void setReInstateBy(UserDTO reInstateBy) {
        this.reInstateBy = reInstateBy;
    }

    public Date getReInstateDatetime() {
        return reInstateDatetime;
    }

    public void setReInstateDatetime(Date reInstateDatetime) {
        this.reInstateDatetime = reInstateDatetime;
    }

    public Double getCreditCardAmount() {
        return creditCardAmount;
    }

    public void setCreditCardAmount(Double creditCardAmount) {
        this.creditCardAmount = creditCardAmount;
    }

    public String getCreditCardInd() {
        return creditCardInd;
    }

    public void setCreditCardInd(String creditCardInd) {
        this.creditCardInd = creditCardInd;
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

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomTypeDesc() {
        return roomTypeDesc;
    }

    public void setRoomTypeDesc(String roomTypeDesc) {
        this.roomTypeDesc = roomTypeDesc;
    }

    public String getChargeRoomType() {
        return chargeRoomType;
    }

    public void setChargeRoomType(String chargeRoomType) {
        this.chargeRoomType = chargeRoomType;
    }

    public Integer getNumOfKey() {
        return numOfKey;
    }

    public void setNumOfKey(Integer numOfKey) {
        this.numOfKey = numOfKey;
    }

    public Double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(Double roomRate) {
        this.roomRate = roomRate;
    }

    public Double getChargeRoomRate() {
        return chargeRoomRate;
    }

    public void setChargeRoomRate(Double chargeRoomRate) {
        this.chargeRoomRate = chargeRoomRate;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDiscountInd() {
        return discountInd;
    }

    public void setDiscountInd(String discountInd) {
        this.discountInd = discountInd;
    }

    public String getSplitInd() {
        return splitInd;
    }

    public void setSplitInd(String splitInd) {
        this.splitInd = splitInd;
    }

    public Double getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(Double splitAmount) {
        this.splitAmount = splitAmount;
    }

    public Double getSplitPercentage() {
        return splitPercentage;
    }

    public void setSplitPercentage(Double splitPercentage) {
        this.splitPercentage = splitPercentage;
    }

    public String getLateCheckOut() {
        return lateCheckOut;
    }

    public void setLateCheckOut(String lateCheckOut) {
        this.lateCheckOut = lateCheckOut;
    }

    public Integer getNumOfExtraBed() {
        return numOfExtraBed;
    }

    public void setNumOfExtraBed(Integer numOfExtraBed) {
        this.numOfExtraBed = numOfExtraBed;
    }

    public Integer getNumOfCrib() {
        return numOfCrib;
    }

    public void setNumOfCrib(Integer numOfCrib) {
        this.numOfCrib = numOfCrib;
    }

    public String getRoomPreference() {
        return roomPreference;
    }

    public void setRoomPreference(String roomPreference) {
        this.roomPreference = roomPreference;
    }

    public String getSpecialRequestInd() {
        return specialRequestInd;
    }

    public void setSpecialRequestInd(String specialRequestInd) {
        this.specialRequestInd = specialRequestInd;
    }

    public String getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(String estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public String getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(String estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public Date getCheckedInDatetime() {
        return checkedInDatetime;
    }

    public void setCheckedInDatetime(Date checkedInDatetime) {
        this.checkedInDatetime = checkedInDatetime;
    }

    public Date getCheckedOutDatetime() {
        return checkedOutDatetime;
    }

    public void setCheckedOutDatetime(Date checkedOutDatetime) {
        this.checkedOutDatetime = checkedOutDatetime;
    }

    public Date getCheckInHotelDate() {
        return checkInHotelDate;
    }

    public void setCheckInHotelDate(Date checkInHotelDate) {
        this.checkInHotelDate = checkInHotelDate;
    }

    public Date getCheckOutHotelDate() {
        return checkOutHotelDate;
    }

    public void setCheckOutHotelDate(Date checkOutHotelDate) {
        this.checkOutHotelDate = checkOutHotelDate;
    }

    public String getWalkInInd() {
        return walkInInd;
    }

    public void setWalkInInd(String walkInInd) {
        this.walkInInd = walkInInd;
    }

    public String getNonGuestInd() {
        return nonGuestInd;
    }

    public void setNonGuestInd(String nonGuestInd) {
        this.nonGuestInd = nonGuestInd;
    }

    public String getNightAuditInd() {
        return nightAuditInd;
    }

    public void setNightAuditInd(String nightAuditInd) {
        this.nightAuditInd = nightAuditInd;
    }

    public String getAddRoomInd() {
        return addRoomInd;
    }

    public void setAddRoomInd(String addRoomInd) {
        this.addRoomInd = addRoomInd;
    }

    public String getSelfCheckinInd() {
        return selfCheckinInd;
    }

    public void setSelfCheckinInd(String selfCheckinInd) {
        this.selfCheckinInd = selfCheckinInd;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public Integer getNumOfBreakfast() {
        return numOfBreakfast;
    }

    public void setNumOfBreakfast(Integer numOfBreakfast) {
        this.numOfBreakfast = numOfBreakfast;
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
    
    public RegistrationDTO getParentRegistration() {
        return parentRegistration;
    }

    public void setParentRegistration(RegistrationDTO parentRegistration) {
        this.parentRegistration = parentRegistration;
    }
    
    public Double getTotalRoomCharge() {
        return totalRoomCharge;
    }

    public void setTotalRoomCharge(Double totalRoomCharge) {
        this.totalRoomCharge = totalRoomCharge;
    }

    public Double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Double baseRate) {
        this.baseRate = baseRate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(Double advancePayment) {
        this.advancePayment = advancePayment;
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
        if (!(object instanceof RegistrationDTO)) {
            return false;
        }
        RegistrationDTO other = (RegistrationDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.dto.fd.RegistrationDTO[ id=" + id + " ]";
    }

}
