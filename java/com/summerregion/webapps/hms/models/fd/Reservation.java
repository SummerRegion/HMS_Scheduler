/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.models.fd;

import com.summerregion.webapps.hms.models.gn.User;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Formula;

/**
 *
 * @author Faizul
 */
@Entity
@Table(name="FDRESERVATION")
@NamedQueries({
    @NamedQuery(name="Reservation.findByFdReservationId"
            , query="SELECT r FROM Reservation r WHERE r.id =:fdrevId"),
    @NamedQuery(name="Reservation.SearchReserByRevNo", query="SELECT rv FROM Reservation rv WHERE rv.reservationNumber=:revNo")
    , @NamedQuery(name="Reservation.searchRevByPersonIdNoContactNo", query="SELECT DISTINCT rv FROM Registration r, Reservation rv WHERE r.reservation.id = rv.id "
            + "AND rv.reservationStatus= '1' AND r.person.idNo = :idNo AND r.person.idType IN (:idType) AND r.person.mobilePhone = :cNo AND r.registrationStatus = '4'")   
    , @NamedQuery(name="Reservation.searchRevTotalNumOfNight", query="SELECT SUM(r.numOfNight) FROM Registration r WHERE r.reservation.id = :resId "
        + "AND r.principalInd='Y' AND r.registrationStatus IN ('5', '6', '7')")     
})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "FDRESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGlobal")
    @SequenceGenerator(name = "seqGlobal", sequenceName = "SQ_GLOBAL_SEQUENCE", allocationSize=1)
    private Long id;

    @Column(name = "RESERVATION_NO", length = 20)
    private String reservationNumber;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "BOOKING_FDPERSON_ID", referencedColumnName = "FDPERSON_ID")
    private Person bookingPerson;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "GUEST_FDPERSON_ID", referencedColumnName = "FDPERSON_ID")
    private Person guestPerson;
    
    @Column(name = "ARRIVAL_DATETIME", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date arrivalDate;

    @Column(name = "DEPARTURE_DATETIME", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date departureDate;
    
    @Column(name = "CONTACT_PERSON", length = 100)
    private String contactPerson;
    @Column(name = "CONTACT_NO", length = 40)
    private String contactNumber;
    @Column(name = "EMAIL_ADDR", length = 60)
    private String emailAddress;
    @Column(name = "FAX", length = 40)
    private String fax;

    @Column(name = "UNIT", length = 100)
    private String unit;

    @Column(name = "RESERVATION_SOURCE", length = 20)
    private String reservationSource;
    @Formula(" FN_GETCODEDESC('RVS', RESERVATION_SOURCE) ")
    private String reservationSourceDesc;

    @Column(name = "SEGMENTS", length = 20)
    private String segments;
    @Formula(" FN_GETCODEDESC('SEG', SEGMENTS) ")
    private String segmentsDesc;
    
    @Column(name = "RESERVATION_STATUS", length = 20)
    private String reservationStatus;
    @Formula(" FN_GETCODEDESC('RVT', RESERVATION_STATUS) ")
    private String reservationStatusDesc;
    
    @Column(name = "RESERVATION_TYPE", length = 20)
    private String reservationType;
    @Formula(" FN_GETCODEDESC('RTY', RESERVATION_TYPE) ")
    private String reservationTypeDesc;

    @Column(name = "GROUP_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String groupInd;
    @Column(name = "GROUP_NAME", length = 100)
    private String groupName;
    
    @Column(name = "BANK_NAME", length = 100)
    private String bankName;
    @Column(name = "CREDIT_CARD_NO", length = 50)
    private String creditCardNumber;
    @Column(name = "EXPIRY_DATE", length = 10)
    private String expiryDate;
    @Column(name = "APPROVAL_CODE", length = 10)
    private String approvalCode;
    @Column(name = "BILLING_INSTRUCTION", length = 2000)
    private String billingInstruction;
    @Column(name = "WAITING_LIST_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String waitingListInd;
    @Column(name = "NO_OF_ROOM", precision = 5, scale = 0)
    private Integer numOfRoom;
    
    @Column(name = "EVENT_IND", length = 1, columnDefinition = "CHAR(1 BYTE) DEFAULT 'N'")
    private String eventInd;
    
    @Column(name = "REMARKS", length = 2000)
    private String remarks;
    
    @Column(name = "OTA_BOOKING_NO", length = 20)
    private String bookingNo;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="reservation" ,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Registration> registrationList;

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

    public Person getBookingPerson() {
        return bookingPerson;
    }

    public void setBookingPerson(Person bookingPerson) {
        this.bookingPerson = bookingPerson;
    }

    public Person getGuestPerson() {
        return guestPerson;
    }

    public void setGuestPerson(Person guestPerson) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.fd.Reservation[ id=" + id + " ]";
    }

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }
}
