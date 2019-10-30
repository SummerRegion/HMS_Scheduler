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
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Formula;

/**
 *
 * @author Faizul (zulcomp) Ngsrimin
 */
@Entity
@Table(name = "GNROOM")
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
    , @NamedQuery(name = "Room.findByGnroomId", query = "SELECT r FROM Room r WHERE r.gnroomId = :gnroomId")
    , @NamedQuery(name = "Room.findByFloorNo", query = "SELECT r FROM Room r WHERE r.floorNo = :floorNo")
    , @NamedQuery(name = "Room.findBySmokingInd", query = "SELECT r FROM Room r WHERE r.smokingInd = :smokingInd")
    , @NamedQuery(name = "Room.findByRoomStatus", query = "SELECT r FROM Room r WHERE r.roomStatus = :roomStatus")
})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GNROOM_ID", nullable = false, precision = 38, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqSetup")
    @SequenceGenerator(name="seqSetup", sequenceName="SQ_SETUP_SEQUENCE", allocationSize=1)
    private Long gnroomId;
    @Size(max = 20)
    @Column(name = "FLOOR_NO", length = 20)
    private String floorNo;
    @Size(max = 20)
    @Column(name = "ROOM_NO", length = 20)
    private String roomNo;
    @Column(name = "SMOKING_IND")
    private Character smokingInd;
    @Size(max = 2000)
    @Column(name= "REMARKS", length = 2000)
    private String remarks;
    @Size(max = 20)
    @Column(name = "ROOM_STATUS", length = 20)
    private String roomStatus;
    @Formula(value = " FN_GETCODEDESC('RST', ROOM_STATUS) ")
    private String roomStatusDesc;
    @Size(max = 20)
    @Column(name = "HOUSEKEEPING_STATUS", length = 20)
    private String housekeepingStatus;
    @Formula(value = " FN_GETCODEDESC('HSS', HOUSEKEEPING_STATUS) ")
    private String housekeepingStatusDesc;
    @Column(name = "ASSIGN_IND")
    private Character assignInd;
    @Column(name = "NIGHT_AUDIT_IND")
    private Character nightAuditInd;
    @JoinColumn(name = "GNROOMTYPE_ID", referencedColumnName = "GNROOMTYPE_ID")
    @ManyToOne
    private RoomType roomType;
    
    public Room() {
    }

    public Room(Long gnroomId) {
        this.gnroomId = gnroomId;
    }

    public Long getGnroomId() {
        return gnroomId;
    }

    public void setGnroomId(Long gnroomId) {
        this.gnroomId = gnroomId;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Character getSmokingInd() {
        return smokingInd;
    }

    public void setSmokingInd(Character smokingInd) {
        this.smokingInd = smokingInd;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getHousekeepingStatus() {
        return housekeepingStatus;
    }

    public void setHousekeepingStatus(String housekeepingStatus) {
        this.housekeepingStatus = housekeepingStatus;
    }

    public String getRoomStatusDesc() {
        return roomStatusDesc;
    }

    public void setRoomStatusDesc(String roomStatusDesc) {
        this.roomStatusDesc = roomStatusDesc;
    }

    public String getHousekeepingStatusDesc() {
        return housekeepingStatusDesc;
    }

    public void setHousekeepingStatusDesc(String housekeepingStatusDesc) {
        this.housekeepingStatusDesc = housekeepingStatusDesc;
    }

    public Character getAssignInd() {
        return assignInd;
    }

    public void setAssignInd(Character assignInd) {
        this.assignInd = assignInd;
    }

    public Character getNightAuditInd() {
        return nightAuditInd;
    }

    public void setNightAuditInd(Character nightAuditInd) {
        this.nightAuditInd = nightAuditInd;
    }

    public RoomType getRoomType() {
        return this.roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gnroomId != null ? gnroomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.gnroomId == null && other.gnroomId != null) || (this.gnroomId != null && !this.gnroomId.equals(other.gnroomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.gn.Room[ gnroomId=" + gnroomId + " ]";
    }
    
}
