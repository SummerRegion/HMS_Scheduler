/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.dto.gn;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Faizul (zulcomp) Ngsrimin
 */
public class RoomDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long gnroomId;
    private String floorNo;
    private String roomNo;
    private Character smokingInd;
    private String remarks;
    private String roomStatus;
    private String roomStatusDesc;
    private String housekeepingStatus;
    private String housekeepingStatusDesc;
    private Character assignInd;
    private Character nightAuditInd;
    private RoomTypeDTO roomType;
    private Date enteredDatetime;
    private UserDTO enteredBy;
    private String activeInd;
    private String[] roomList;
    
    public RoomDTO() {
    }

    public RoomDTO(Long gnroomId) {
        this.gnroomId = gnroomId;
    }

    public RoomDTO(Long gnroomId, Date enteredDatetime, UserDTO enteredBy) {
        this.gnroomId = gnroomId;
        this.enteredDatetime = enteredDatetime;
        this.enteredBy = enteredBy;
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

    public void setEnteredBy(UserDTO enteredBy) {
        this.enteredBy = enteredBy;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd; 
    }

    public String getActiveInd() {
        return activeInd;
    }

    public Date getEnteredDatetime() {
        return enteredDatetime;
    }

    public void setEnteredDatetime(Date enteredDatetime) {
        this.enteredDatetime = enteredDatetime;
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

    public UserDTO getEnteredBy() {
        return enteredBy;
    }

    public RoomTypeDTO getRoomType() {
        return this.roomType;
    }

    public void setRoomType(RoomTypeDTO roomType) {
        this.roomType = roomType;
    }
    
    public String[] getRoomList() {
        return roomList;
    }
    
    public void setRoomList(String[] roomList) {
        this.roomList = roomList;
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
        if (!(object instanceof RoomDTO)) {
            return false;
        }
        RoomDTO other = (RoomDTO) object;
        if ((this.gnroomId == null && other.gnroomId != null) || (this.gnroomId != null && !this.gnroomId.equals(other.gnroomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.dto.gn.RoomDTO[ gnroomId=" + gnroomId + " ]";
    }
    
}
