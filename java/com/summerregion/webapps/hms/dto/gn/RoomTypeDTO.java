/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.dto.gn;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Faizul (zulcomp) Ngsrimin
 */

public class RoomTypeDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Long gnroomtypeId;
    private String roomType;
    private String roomTypeDesc;
    private Short extraBed;
    private Short noOfCrib;
    private Short maxAdult;
    private Short maxChild;
    private List<RoomDTO> roomList;
    private UserDTO enteredBy;
    private Date enteredDatetime;
    private String activeInd;
    
    public RoomTypeDTO() {
    }

    public RoomTypeDTO(Long gnroomtypeId) {
        this.gnroomtypeId = gnroomtypeId;
    }

    public RoomTypeDTO(Long gnroomtypeId, Date enteredDatetime, UserDTO enteredBy) {
        this.gnroomtypeId = gnroomtypeId;
        this.enteredDatetime = enteredDatetime;
        this.enteredBy = enteredBy;
    }

    public Long getGnroomtypeId() {
        return gnroomtypeId;
    }

    public void setGnroomtypeId(Long gnroomtypeId) {
        this.gnroomtypeId = gnroomtypeId;
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
    
    public Short getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(Short extraBed) {
        this.extraBed = extraBed;
    }

    public Short getNoOfCrib() {
        return noOfCrib;
    }

    public void setNoOfCrib(Short noOfCrib) {
        this.noOfCrib = noOfCrib;
    }

    public Short getMaxAdult() {
        return maxAdult;
    }

    public void setMaxAdult(Short maxAdult) {
        this.maxAdult = maxAdult;
    }

    public Short getMaxChild() {
        return maxChild;
    }

    public void setMaxChild(Short maxChild) {
        this.maxChild = maxChild;
    }

    
    public List<RoomDTO> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<RoomDTO> roomList) {
        this.roomList = roomList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gnroomtypeId != null ? gnroomtypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomTypeDTO)) {
            return false;
        }
        RoomTypeDTO other = (RoomTypeDTO) object;
        if ((this.gnroomtypeId == null && other.gnroomtypeId != null) || (this.gnroomtypeId != null && !this.gnroomtypeId.equals(other.gnroomtypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.dto.gn.RoomTypeDTO[ gnroomtypeId=" + gnroomtypeId + " ]";
    }
    
}
