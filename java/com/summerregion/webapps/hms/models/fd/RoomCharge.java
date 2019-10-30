/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.models.fd;

import com.summerregion.webapps.hms.models.gn.User;
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
import javax.persistence.ManyToOne;
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
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name="FDROOMCHARGE")
@NamedEntityGraphs (
    {
        @NamedEntityGraph(name = "graph.RoomCharge.reservation.registration", 
            attributeNodes = {
                @NamedAttributeNode("reservation"),
                @NamedAttributeNode(value = "registration", subgraph = "personRoom")
            },
            subgraphs = {
                @NamedSubgraph(name = "personRoom", 
                    attributeNodes = { 
                        @NamedAttributeNode("person"), 
                        @NamedAttributeNode("room")
                    }
                )
            }
        )
    }
)
@NamedQueries( {
    @NamedQuery(name="RoomCharge.sumTotalAmtChargePerReg", query="SELECT SUM(rc.totalAmount) FROM RoomCharge rc WHERE rc.registration.id=:rId AND rc.activeInd='Y'"),
    @NamedQuery(name="RoomCharge.sumRoomChargePerReg", query="SELECT SUM(rc.baseRate) FROM RoomCharge rc WHERE rc.registration.id=:rId AND rc.activeInd='Y'"),
    @NamedQuery(name="RoomCharge.getRoomChargeByRegistrationId", query="SELECT rc FROM RoomCharge rc WHERE rc.registration.id=:rId AND rc.activeInd='Y' ORDER BY rc.transactionDate"),
    @NamedQuery(name="RoomCharge.getRoomChargeByReservationId", query="SELECT rc FROM RoomCharge rc WHERE rc.reservation.id=:rId AND rc.activeInd='Y'"),
    @NamedQuery(name="RoomCharge.getRoomChargeByRegIdTxnDate", query="SELECT rc FROM RoomCharge rc WHERE rc.registration.id=:rId AND rc.transactionDate=:txnDate AND rc.activeInd='Y' ORDER BY rc.transactionDate"),
    @NamedQuery(name="RoomCharge.sumTotalAmtChargeByTxnDate", query="SELECT SUM(rc.totalAmount) FROM RoomCharge rc WHERE rc.registration.id in (:rId) AND rc.transactionDate=:txnDate AND rc.activeInd='Y'"),
    @NamedQuery(name="RoomCharge.getChargeByFirstStayOverDate", query="SELECT rc FROM RoomCharge rc WHERE rc.registration.id=:rId AND rc.transactionDate=:firstDate AND rc.activeInd='Y'")
})
public class RoomCharge implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "FDROOMCHARGE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqGlobal")
    @SequenceGenerator(name="seqGlobal", sequenceName="SQ_GLOBAL_SEQUENCE", allocationSize=1)
    private Long fdroomchargeId;
    
    @ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="FDRESERVATION_ID", referencedColumnName="FDRESERVATION_ID")
    private Reservation reservation;
    
    @ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="FDREGISTRATION_ID", referencedColumnName="FDREGISTRATION_ID")
    private Registration registration;
    
    @Column(name = "TXN_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transactionDate;
    
    @Column(name = "BASE_RATE", precision=12, scale=2)
    private Double baseRate;
    
    @Column(name = "CHARGE_PRICE", precision=12, scale=2)
    private Double chargePrice;
    
//    @Column(name = "AMOUNT", precision=12, scale=2)
//    private Double amount;
//    
//    @Column(name = "GST_AMOUNT", precision=12, scale=2)
//    private Double gstAmount;
    
    @Column(name = "TOTAL_AMOUNT", precision=12, scale=2)
    private Double totalAmount;
    
    @Column(name = "POST_IND",length=1, columnDefinition="CHAR(1) DEFAULT 'N'" )
    private String postInd;
    
    @Column(name = "NIGHT_AUDIT_IND",length=1, columnDefinition="CHAR(1) DEFAULT 'N'" )
    private String nightAuditInd;
    
    @Column(name = "ACTIVE_IND",length=1, columnDefinition="CHAR(1) DEFAULT 'N'" )
    private String activeInd;
    
    @ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="ENTERED_BY", referencedColumnName="GNUSER_ID")
    private User enteredBy;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional = false)
    @Column(name = "ENTERED_DATETIME", nullable = false)
    protected Date enteredDatetime;
    
    @ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="POSTED_BY", referencedColumnName="GNUSER_ID")
    private User postedBy;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "POSTED_DATETIME", nullable = false)
    protected Date postedDatetime;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fdroomchargeId != null ? fdroomchargeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RoomCharge)) {
            return false;
        }
        RoomCharge other = (RoomCharge) object;
        if ((this.fdroomchargeId == null && other.fdroomchargeId != null) || 
                (this.fdroomchargeId != null && !this.fdroomchargeId.equals(other.fdroomchargeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.RoomCharge[ id=" + fdroomchargeId + " ]";
    }

    public Long getFdroomchargeId() {
        return fdroomchargeId;
    }

    public void setFdroomchargeId(Long fdroomchargeId) {
        this.fdroomchargeId = fdroomchargeId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(Double baseRate) {
        this.baseRate = baseRate;
    }

    public Double getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(Double chargePrice) {
        this.chargePrice = chargePrice;
    }

//    public Double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(Double amount) {
//        this.amount = amount;
//    }
//
//    public Double getGstAmount() {
//        return gstAmount;
//    }
//
//    public void setGstAmount(Double gstAmount) {
//        this.gstAmount = gstAmount;
//    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPostInd() {
        return postInd;
    }

    public void setPostInd(String postInd) {
        this.postInd = postInd;
    }

    public String getNightAuditInd() {
        return nightAuditInd;
    }

    public void setNightAuditInd(String nightAuditInd) {
        this.nightAuditInd = nightAuditInd;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }

    public User getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(User enteredBy) {
        this.enteredBy = enteredBy;
    }

    public Date getEnteredDatetime() {
        return enteredDatetime;
    }

    public void setEnteredDatetime(Date enteredDatetime) {
        this.enteredDatetime = enteredDatetime;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    public Date getPostedDatetime() {
        return postedDatetime;
    }

    public void setPostedDatetime(Date postedDatetime) {
        this.postedDatetime = postedDatetime;
    }
       
    
}
