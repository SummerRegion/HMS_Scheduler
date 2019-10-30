/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.models.fd;

import com.summerregion.webapps.hms.models.gn.Room;
import com.summerregion.webapps.hms.models.gn.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Formula;

/**
 *
 * @author Faizul
 */
@Entity
@Table(name="FDREGISTRATION")
@NamedQueries({
    @NamedQuery(name="Registration.countRegistrationId", query="SELECT COUNT(r.id) FROM Registration r WHERE r.reservation.id =:fdrevId AND r.registrationStatus <> '3'")
    ,@NamedQuery(name="Registration.SearchRegByRevNoDueIn", query="SELECT r FROM Registration r WHERE r.registrationStatus='4' AND r.reservation.reservationNumber = :revNo AND r.person.mobilePhone = :contactNo")        
	,@NamedQuery(name="Registration.findOccRoomId", query="SELECT r FROM Registration r, Room rm, RoomType rt WHERE r.room.gnroomId = rm.gnroomId AND rm.roomType.gnroomtypeId = rt.gnroomtypeId AND r.registrationStatus NOT IN ('2','3','7','8') AND r.arrivalDate < :depDate AND r.departureDate > :arrDate AND (:roomType IS NULL OR rm.roomType.roomType = :roomType)") 
	,@NamedQuery(name="Registration.findByPersonId", query="SELECT r FROM Registration r WHERE r.person.personId =:personId")
        ,@NamedQuery(name="Registration.findPrincipalSharerSplit", query="SELECT r FROM Registration r WHERE (r.id =:regId) OR (r.parentRegistration.id = :regId AND r.splitInd IN ('A','P')) ORDER BY r.principalInd DESC")    
        ,@NamedQuery(name="Registration.findPrincipalSharerByRegStatus", query="SELECT r FROM Registration r WHERE (r.id =:regId OR r.parentRegistration.id = :regId) AND r.registrationStatus IN (:regStatus) ORDER BY r.principalInd DESC")   
	,@NamedQuery(name="Registration.findByParentRegistrationId", query="SELECT r FROM Registration r WHERE r.parentRegistration.id =:fdregId")
        ,@NamedQuery(name="Registration.findPrincipalSharerRegId", query="SELECT r FROM Registration r WHERE (r.id =:regId) OR (r.parentRegistration.id = :regId ) ORDER BY r.principalInd DESC")
        ,@NamedQuery(name="Registration.countOccupiedRoomByRoomId", query="SELECT COUNT(r.id) FROM Registration r WHERE r.room =:room AND r.registrationStatus IN ('5','6')") 
        ,@NamedQuery(name="Registration.findSameRoomReg", query="SELECT r FROM Registration r WHERE r.registrationStatus IN ('5','6') AND r.arrivalDate = :arrivalDate AND r.departureDate = :departureDate AND r.room.gnroomId = :gnroomId") 
        ,@NamedQuery(name="Registration.findSharerSplit", query="SELECT r FROM Registration r WHERE r.parentRegistration.id = :regId AND r.splitInd IN ('A','P') AND r.principalInd='N'") 
})
@NamedEntityGraphs({
    @NamedEntityGraph(name = "graph.Registration.Room", attributeNodes = {@NamedAttributeNode(value = "room")})
})
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "FDREGISTRATION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGlobal")
    @SequenceGenerator(name = "seqGlobal", sequenceName = "SQ_GLOBAL_SEQUENCE", allocationSize=1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "FDRESERVATION_ID", referencedColumnName = "FDRESERVATION_ID")
    private Reservation reservation;

    @Column(name = "REGISTRATION_NO", length = 20, nullable = false)
    private String registrationNumber;
    @Column(name = "REGISTRATION_STATUS", length = 20)
    private String registrationStatus;
    @Formula(" FN_GETCODEDESC('RGS', REGISTRATION_STATUS) ")
    private String registrationStatusDesc;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "FDPERSON_ID", referencedColumnName = "FDPERSON_ID")
    private Person person;

    @Column(name = "PRINCIPAL_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String principalInd;    
    
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "PARENT_FDREGISTRATION_ID" , referencedColumnName = "FDREGISTRATION_ID")
    private Registration parentRegistration;
    
    @Column(name = "ARRIVAL_DATETIME", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date arrivalDate;

    @Column(name = "DEPARTURE_DATETIME", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date departureDate;
    @Column(name = "NO_OF_NIGHT", precision = 10, scale = 0)
    private Integer numOfNight;

    @Column(name = "OCCUPANCY_TYPE", length = 20)
    private String occupancyType;
    @Formula(" FN_GETCODEDESC('OCT', OCCUPANCY_TYPE) ")
    private String occupancyTypeDesc;

    @Column(name = "NO_OF_ADULT", precision = 5, scale = 0)
    private Integer numOfAdult;
    @Column(name = "NO_OF_CHILD", precision = 5, scale = 0)
    private Integer numOfChild;
    
    @Column(name = "REASON_TYPE", length = 20)
    private String reasonType;
    @Column(name = "REASON_CODE", length = 20)
    private String reasonCode;
    @Column(name = "REASON_DESC", length = 2000)
    private String reasonDescription;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "CANCELLED_BY", referencedColumnName = "GNUSER_ID")
    private User cancelledBy;
    
    @Column(name = "CANCELLED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelledDatetime;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "REINSTATE_BY", referencedColumnName = "GNUSER_ID")
    private User reInstateBy;
    
    @Column(name = "REINSTATE_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reInstateDatetime;
    
    @Column(name = "CREDIT_CARD_AMOUNT", precision = 14, scale = 2)
    private Double creditCardAmount;
    @Column(name = "CREDIT_CARD_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String creditCardInd;
    //@Column(name = "GNPAYMENTMODE_ID          NUMBER(38),
    @Column(name = "BANK_NAME", length = 100)
    private String bankName;
    @Column(name = "CREDIT_CARD_NO", length = 50)
    private String creditCardNumber;
    @Column(name = "EXPIRY_DATE", length = 10)
    private String expiryDate;
    @Column(name = "APPROVAL_CODE", length = 10)
    private String approvalCode;

    @Column(name = "ROOM_TYPE", length = 20)
    private String roomType;
    @Formula(" FN_GETCODEDESC('RMT', ROOM_TYPE) ")
    private String roomTypeDesc;
    @Column(name = "CHARGE_ROOM_TYPE", length = 20)
    private String chargeRoomType;

    @Column(name = "NO_KEY_CARD", precision = 3, scale = 0)
    Integer numOfKey;

    @Column(name = "ROOM_RATE", precision = 12, scale = 2)
    private Double roomRate;
    @Column(name = "CHARGE_ROOM_RATE", precision = 12, scale = 2)
    private Double chargeRoomRate;
	
    @ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(name="GNROOM_ID", referencedColumnName="GNROOM_ID")
    private Room room;
    
    @Column(name = "DISC_AMT", precision = 12, scale = 2)
    private Double discountAmount;
    @Column(name = "DISC_PERCENTAGE", precision = 12, scale = 2)
    private Double discountPercentage;
    @Column(name = "DISC_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String discountInd;
    @Column(name = "SPLIT_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT NULL")
    private String splitInd;
    @Column(name = "SPLIT_AMOUNT", precision = 12, scale = 2)
    private Double splitAmount;
    @Column(name = "SPLIT_PERCENTAGE", precision = 12, scale = 2)
    private Double splitPercentage;
    @Column(name = "LATE_CHECK_OUT", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String lateCheckOut;
    @Column(name = "NO_OF_EXTRA_BED", precision = 5, scale = 0)
    private Integer numOfExtraBed;
    @Column(name = "NO_OF_CRIB", precision = 5, scale = 0)
    private Integer numOfCrib;
    @Column(name = "ROOM_PREFERENCE", length = 2000)
    private String roomPreference;
    @Column(name = "SPE_REQ_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String specialRequestInd;
    @Column(name = "EST_ARRIVAL_TIME", length = 10)
    private String estimatedArrivalTime;
    @Column(name = "EST_DEPARTURE_TIME", length = 10)
    private String estimatedDepartureTime;
    @Column(name = "PICK_UP_TIME", length = 10)
    private String pickUpTime;
    
    @Column(name = "CHECKED_IN_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkedInDatetime;
    
    @Column(name = "CHECKED_OUT_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkedOutDatetime;
    
    @Column(name = "CHECK_IN_HOTEL_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date checkInHotelDate;
    @Column(name = "CHECK_OUT_HOTEL_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date checkOutHotelDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "CHECKED_IN_BY", referencedColumnName="GNUSER_ID")
    private User checkedInBy;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "CHECKED_OUT_BY", referencedColumnName="GNUSER_ID")
    private User checkedOutBy;
    
    @Column(name = "WALK_IN_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String walkInInd;
    @Column(name = "NON_GUEST_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String nonGuestInd;
    @Column(name = "NIGHT_AUDIT_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String nightAuditInd;
    @Column(name = "ADD_ROOM_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String addRoomInd;
    @Column(name = "SELF_CHECKIN_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String selfCheckinInd;
    @Column(name = "REMARKS", length = 2000)
    private String remarks;
    @Column(name = "NO_OF_BREAKFAST", precision = 5, scale = 0)
    private Integer numOfBreakfast;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
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

    public User getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(User cancelledBy) {
        this.cancelledBy = cancelledBy;
    }

    public Date getCancelledDatetime() {
        return cancelledDatetime;
    }

    public void setCancelledDatetime(Date cancelledDatetime) {
        this.cancelledDatetime = cancelledDatetime;
    }

    public User getReInstateBy() {
        return reInstateBy;
    }

    public void setReInstateBy(User reInstateBy) {
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
    
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
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

    public User getCheckedInBy() {
        return checkedInBy;
    }

    public void setCheckedInBy(User checkedInBy) {
        this.checkedInBy = checkedInBy;
    }

    public User getCheckedOutBy() {
        return checkedOutBy;
    }

    public void setCheckedOutBy(User checkedOutBy) {
        this.checkedOutBy = checkedOutBy;
    }
    
    public Integer getNumOfBreakfast() {
        return numOfBreakfast;
    }

    public void setNumOfBreakfast(Integer numOfBreakfast) {
        this.numOfBreakfast = numOfBreakfast;
    }

    public Registration getParentRegistration() {
        return parentRegistration;
    }

    public void setParentRegistration(Registration parentRegistration) {
        this.parentRegistration = parentRegistration;
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
        if (!(object instanceof Registration)) {
            return false;
        }
        Registration other = (Registration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.fd.Registration[ id=" + id + " ]";
    }
}
