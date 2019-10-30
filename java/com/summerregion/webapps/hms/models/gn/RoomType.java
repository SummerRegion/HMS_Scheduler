/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.models.gn;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Formula;

/**
 *
 * @author Faizul (zulcomp) Ngsrimin
 */
@Entity
@Table(name = "GNROOMTYPE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ROOM_TYPE"})})
@NamedQueries({
    @NamedQuery(name = "RoomType.findAll", query = "SELECT r FROM RoomType r ORDER BY r.roomTypeDesc")
    , @NamedQuery(name = "RoomType.findByGnroomtypeId", query = "SELECT r FROM RoomType r WHERE r.gnroomtypeId = :gnroomtypeId")
    , @NamedQuery(name = "RoomType.findByRoomType", query = "SELECT r FROM RoomType r WHERE r.roomType = :roomType")
    , @NamedQuery(name = "RoomType.findByExtraBed", query = "SELECT r FROM RoomType r WHERE r.extraBed = :extraBed")
    , @NamedQuery(name = "RoomType.findByNoOfCrib", query = "SELECT r FROM RoomType r WHERE r.noOfCrib = :noOfCrib")
    , @NamedQuery(name = "RoomType.findByMaxAdult", query = "SELECT r FROM RoomType r WHERE r.maxAdult = :maxAdult")
    , @NamedQuery(name = "RoomType.findByMaxChild", query = "SELECT r FROM RoomType r WHERE r.maxChild = :maxChild")
    })
public class RoomType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GNROOMTYPE_ID", nullable = false, precision = 38, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seqSetup")
    @SequenceGenerator(name="seqSetup", sequenceName="SQ_SETUP_SEQUENCE", allocationSize=1)
    private Long gnroomtypeId;
    
    @Size(max = 20)
    @Column(name = "ROOM_TYPE", length = 20)
    private String roomType;
    @Formula(value = " FN_GETCODEDESC('RMT', ROOM_TYPE) ")
    private String roomTypeDesc;
    @Column(name = "EXTRA_BED")
    private Short extraBed;
    @Column(name = "NO_OF_CRIB")
    private Short noOfCrib;
    @Column(name = "MAX_ADULT")
    private Short maxAdult;
    @Column(name = "MAX_CHILD")
    private Short maxChild;
    @OneToMany(mappedBy = "roomType")
    private List<Room> roomList;
    
    public RoomType() {
    }

    public RoomType(Long gnroomtypeId) {
        this.gnroomtypeId = gnroomtypeId;
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

    public void setRoomTypeDesc(String roomType) {
        this.roomType = roomType;
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

    
    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
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
        if (!(object instanceof RoomType)) {
            return false;
        }
        RoomType other = (RoomType) object;
        if ((this.gnroomtypeId == null && other.gnroomtypeId != null) || (this.gnroomtypeId != null && !this.gnroomtypeId.equals(other.gnroomtypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.summerregion.webapps.hms.models.gn.RoomType[ gnroomtypeId=" + gnroomtypeId + " ]";
    }
    
}
