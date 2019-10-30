/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.managers.fd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.summerregion.webapps.hms.dto.fd.PersonDTO;
import com.summerregion.webapps.hms.dto.fd.RegistrationDTO;
import com.summerregion.webapps.hms.dto.fd.ReservationDTO;
import com.summerregion.webapps.hms.dto.gn.RoomDTO;
import com.summerregion.webapps.hms.dto.gn.RoomTypeDTO;
import com.summerregion.webapps.hms.helper.DTOHelper;
import com.summerregion.webapps.hms.helper.JSONHelper;
import com.summerregion.webapps.hms.models.fd.Registration;
import com.summerregion.webapps.hms.models.gn.Room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author LENOVO
 */
@Stateless
public class RoomGanttChartManager implements IRoomGanttChartManager {
    
    @PersistenceContext
    EntityManager mgr;
    
    //@ILoggable
    Logger logger = LoggerFactory.getLogger(RoomGanttChartManager.class);
    
    private final HashMap<String, String> attrMapRegDTOToReg = new HashMap<String, String>() {
        {
            put("reservation", "reservation");
            put("registrationNumber", "registrationNumber");
            put("registrationStatus", "registrationStatus");
            put("registrationStatusDesc", "registrationStatusDesc");
            put("person", "person");
            put("principalInd", "principalInd");
            put("parentRegistration", "parentRegistration");
            put("arrivalDate", "arrivalDate");
            put("departureDate", "departureDate");
            put("numOfNight", "numOfNight");
            put("occupancyType", "occupancyType");
            put("occupancyTypeDesc", "occupancyTypeDesc");
            put("numOfAdult", "numOfAdult");
            put("numOfChild", "numOfChild");
            put("reasonType", "reasonType");
            put("reasonCode", "reasonCode");
            put("reasonDescription", "reasonDescription");
            put("cancelledBy", "cancelledBy");
            put("cancelledDatetime", "cancelledDatetime");
            put("reInstateBy", "reInstateBy");
            put("reInstateDatetime", "reInstateDatetime");
            put("creditCardAmount", "creditCardAmount");
            put("creditCardInd", "creditCardInd");
            put("bankName", "bankName");
            put("creditCardNumber", "creditCardNumber");
            put("expiryDate", "expiryDate");
            put("approvalCode", "approvalCode");
            put("rate", "rate");
            put("roomType", "roomType");
            put("roomTypeDesc", "roomTypeDesc");
            put("chargeRoomType", "chargeRoomType");
            put("numOfKey", "numOfKey");
            put("roomRate", "roomRate");
            put("chargeRoomRate", "chargeRoomRate");
            put("room", "room");
            put("discountAmount", "discountAmount");
            put("discountPercentage", "discountPercentage");
            put("discountInd", "discountInd");
            put("splitInd", "splitInd");
            put("splitAmount", "splitAmount");
            put("splitPercentage", "splitPercentage");
            put("lateCheckOut", "lateCheckOut");
            put("numOfExtraBed", "numOfExtraBed");
            put("numOfCrib", "numOfCrib");
            put("roomPreference", "roomPreference");
            put("specialRequestInd", "specialRequestInd");
            put("estimatedArrivalTime", "estimatedArrivalTime");
            put("pickUpTime", "pickUpTime");
            put("checkedInDatetime", "checkedInDatetime");
            put("checkedOutDatetime", "checkedOutDatetime");
            put("checkInHotelDate", "checkInHotelDate");
            put("checkOutHotelDate", "checkOutHotelDate");
            put("checkedInBy", "checkedInBy");
            put("checkedOutBy", "checkedOutBy");
            put("walkInInd", "walkInInd");
            put("nonGuestInd", "nonGuestInd");
            put("nightAuditInd", "nightAuditInd");
            put("addRoomInd", "addRoomInd");
            put("selfCheckinInd", "selfCheckinInd");
            put("remarks", "remarks");
        }
    };
    
    private final HashMap<String, String> attrMapRegToRegDTO = new HashMap<String, String>() {
        {
            put("id", "id");
            put("reservation", "reservation");
            put("registrationNumber", "registrationNumber");
            put("registrationStatus", "registrationStatus");
            put("registrationStatusDesc", "registrationStatusDesc");
            put("person", "person");
            put("principalInd", "principalInd");
            put("parentRegistration", "parentRegistration");
            put("arrivalDate", "arrivalDate");
            put("departureDate", "departureDate");
            put("numOfNight", "numOfNight");
            put("occupancyType", "occupancyType");
            put("occupancyTypeDesc", "occupancyTypeDesc");
            put("numOfAdult", "numOfAdult");
            put("numOfChild", "numOfChild");
            put("reasonType", "reasonType");
            put("reasonCode", "reasonCode");
            put("reasonDescription", "reasonDescription");
            put("cancelledBy", "cancelledBy");
            put("cancelledDatetime", "cancelledDatetime");
            put("reInstateBy", "reInstateBy");
            put("reInstateDatetime", "reInstateDatetime");
            put("creditCardAmount", "creditCardAmount");
            put("creditCardInd", "creditCardInd");
            put("bankName", "bankName");
            put("creditCardNumber", "creditCardNumber");
            put("expiryDate", "expiryDate");
            put("approvalCode", "approvalCode");
            put("rate", "rate");
            put("roomType", "roomType");
            put("roomTypeDesc", "roomTypeDesc");
            put("chargeRoomType", "chargeRoomType");
            put("numOfKey", "numOfKey");
            put("roomRate", "roomRate");
            put("chargeRoomRate", "chargeRoomRate");
            put("room", "room");
            put("discountAmount", "discountAmount");
            put("discountPercentage", "discountPercentage");
            put("discountInd", "discountInd");
            put("splitInd", "splitInd");
            put("splitAmount", "splitAmount");
            put("splitPercentage", "splitPercentage");
            put("lateCheckOut", "lateCheckOut");
            put("numOfExtraBed", "numOfExtraBed");
            put("numOfCrib", "numOfCrib");
            put("roomPreference", "roomPreference");
            put("specialRequestInd", "specialRequestInd");
            put("estimatedArrivalTime", "estimatedArrivalTime");
            put("pickUpTime", "pickUpTime");
            put("checkedInDatetime", "checkedInDatetime");
            put("checkedOutDatetime", "checkedOutDatetime");
            put("checkInHotelDate", "checkInHotelDate");
            put("checkOutHotelDate", "checkOutHotelDate");
            put("checkedInBy", "checkedInBy");
            put("checkedOutBy", "checkedOutBy");
            put("walkInInd", "walkInInd");
            put("nonGuestInd", "nonGuestInd");
            put("nightAuditInd", "nightAuditInd");
            put("addRoomInd", "addRoomInd");
            put("selfCheckinInd", "selfCheckinInd");
            put("remarks", "remarks");
        }
    };
    
    private final HashMap<String, String> attrMapRoomToRoomDto = new HashMap<String, String>(){{
        put("roomType","roomType");
        put("roomTypeDesc","roomTypeDesc");
        put("maxAdult","maxAdult");
        put("maxChild","maxChild");
        put("gnroomId","gnroomId");
        put("floorNo","floorNo");
        put("roomNo","roomNo");
        put("remarks","remarks");
        put("smokingInd","smokingInd");
        put("housekeepingStatus","housekeepingStatus");
        put("housekeepingStatusDesc","housekeepingStatusDesc");
    }};

    private final HashMap<String, String> attrMapRoomTypToRoomTypDto = new HashMap<String, String>(){{
        put("gnroomtypeId","gnroomtypeId");
        put("roomType","roomType");
        put("roomTypeDesc","roomTypeDesc");
        put("extraBed","extraBed");
        put("noOfCrib","noOfCrib");
        put("maxAdult","maxAdult");
        put("maxChild","maxChild");
    }};

    private final HashMap<String,String> attrMapPerToPerDTO = new HashMap<String,String>() {{
        put("personId", "personId");
        put("title","title");
        put("name", "name");
        put("nationality", "nationality");
    }};
        
    private final HashMap<String, String> attrMapResToResDTO = new HashMap<String, String>() {
        {
            put("id", "id");
            put("groupInd", "groupInd");
            put("groupName", "groupName");
        }};
    
    @Override
    public String searchRoomGanttChart(RoomDTO rDTO){
        
        StringBuilder sb = new StringBuilder();
        DTOHelper helper = DTOHelper.getInstance();
        List<RoomDTO> rmDTOList = new ArrayList<RoomDTO>();
        
        sb.append("SELECT r FROM Room r WHERE 1=1 ");
        if (rDTO.getHousekeepingStatus()!= null && !"".equals(rDTO.getHousekeepingStatus())){
            sb.append("AND r.housekeepingStatus LIKE :housekeepingStatus ");
        }
        if (rDTO.getRoomType() != null){
            if (rDTO.getRoomType().getRoomType()!= null && !"".equals(rDTO.getRoomType().getRoomType())){
                sb.append("AND r.roomType.roomType LIKE :roomType ");
            }
        }
        sb.append("ORDER BY r.floorNo,r.roomNo");
        
        TypedQuery<Room> q = mgr.createQuery(sb.toString(),Room.class);
        if (rDTO.getRoomNo()!= null && !"".equals(rDTO.getRoomNo())){
            q.setParameter("roomNo", rDTO.getRoomNo());
        }
        if (rDTO.getFloorNo()!= null && !"".equals(rDTO.getFloorNo())){
            q.setParameter("floorNo", rDTO.getFloorNo());
        }
        if (rDTO.getHousekeepingStatus()!= null && !"".equals(rDTO.getHousekeepingStatus())){
            q.setParameter("housekeepingStatus", rDTO.getHousekeepingStatus());
        }
        if (rDTO.getRoomType() != null){
            if (rDTO.getRoomType().getRoomType()!= null && !"".equals(rDTO.getRoomType().getRoomType())){
                q.setParameter("roomType", rDTO.getRoomType().getRoomType());
            }
        }
        List<Room> roomLst = q.getResultList();
        
        for (Room rm : roomLst) {
            RoomDTO nrmDto = new RoomDTO();
            RoomTypeDTO rmTypeDto = new RoomTypeDTO();
            
            helper.updateSrcDescAttributes(rm, nrmDto, attrMapRoomToRoomDto);
            helper.updateSrcDescAttributes(rm.getRoomType(), rmTypeDto, attrMapRoomTypToRoomTypDto);
            
            nrmDto.setRoomType(rmTypeDto);
            
            rmDTOList.add(nrmDto);
        }
        
        try {
            return JSONHelper.getInstance().serialize(rmDTOList);
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(RoomGanttChartManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public String searchGanttChartEvent(RegistrationDTO rDTO){
        
        StringBuilder sb = new StringBuilder();
        DTOHelper helper = DTOHelper.getInstance();
        List<RegistrationDTO> regDTOList = new ArrayList<RegistrationDTO>();
        
        sb.append("SELECT r FROM Registration r WHERE 1=1 ");
        sb.append("AND r.registrationStatus IN ('1', '4', '5', '6') AND r.principalInd='Y' ");
        sb.append("AND r.registrationStatus IN (SELECT MAX(reg.registrationStatus) FROM Registration reg WHERE reg.room.gnroomId=r.room.gnroomId AND reg.registrationStatus IN ('1', '4', '5', '6')) ");
        if (rDTO.getRoom().getHousekeepingStatus()!= null && !"".equals(rDTO.getRoom().getHousekeepingStatus())){
            sb.append("AND r.room.housekeepingStatus LIKE :housekeepingStatus ");
        }
        if (rDTO.getRoom().getRoomType() != null){
            if (rDTO.getRoom().getRoomType().getRoomType()!= null && !"".equals(rDTO.getRoom().getRoomType().getRoomType())){
                sb.append("AND r.room.roomType.roomType LIKE :roomType ");
            }
        }
        sb.append("ORDER BY r.room.floorNo,r.room.roomNo ASC");
        TypedQuery<Registration> q = mgr.createQuery(sb.toString(),Registration.class);
        
//        q.setParameter("arrivalDate", rDTO.getArrivalDate());
//        q.setParameter("departureDate", rDTO.getDepartureDate());
        
        if (rDTO.getRoom().getRoomNo()!= null && !"".equals(rDTO.getRoom().getRoomNo())){
            q.setParameter("roomNo", rDTO.getRoom().getRoomNo());
        }
        if (rDTO.getRoom().getFloorNo()!= null && !"".equals(rDTO.getRoom().getFloorNo())){
            q.setParameter("floorNo", rDTO.getRoom().getFloorNo());
        }
        if (rDTO.getRoom().getHousekeepingStatus()!= null && !"".equals(rDTO.getRoom().getHousekeepingStatus())){
            q.setParameter("housekeepingStatus", rDTO.getRoom().getHousekeepingStatus());
        }
        if (rDTO.getRoom().getRoomType() != null){
            if (rDTO.getRoom().getRoomType().getRoomType()!= null && !"".equals(rDTO.getRoom().getRoomType().getRoomType())){
                q.setParameter("roomType", rDTO.getRoom().getRoomType().getRoomType());
            }
        }
        List<Registration> regLst = q.getResultList();
        
        
        for (Registration reg : regLst) {
            RegistrationDTO regDto = new RegistrationDTO();
            PersonDTO perDto = new PersonDTO();
            PersonDTO guestDto = new PersonDTO();
            RoomDTO nrmDto = new RoomDTO();
            RoomTypeDTO rmTypeDto = new RoomTypeDTO();
            ReservationDTO resDTO = new ReservationDTO();
            
            helper.updateSrcDescAttributes(reg, regDto, attrMapRegToRegDTO);
            helper.updateSrcDescAttributes(reg.getReservation(), resDTO, attrMapResToResDTO);
            if (reg.getReservation().getGuestPerson() != null){
                helper.updateSrcDescAttributes(reg.getReservation().getGuestPerson(), guestDto, attrMapPerToPerDTO);
            }
            if (reg.getPerson() != null){
                helper.updateSrcDescAttributes(reg.getPerson(), perDto, attrMapPerToPerDTO);
            }
            if (reg.getRoom() != null){
                helper.updateSrcDescAttributes(reg.getRoom(), nrmDto, attrMapRoomToRoomDto);
                if (reg.getRoom().getRoomType() != null){
                    helper.updateSrcDescAttributes(reg.getRoom().getRoomType(), rmTypeDto, attrMapRoomTypToRoomTypDto);
                }
            }
            
            nrmDto.setRoomType(rmTypeDto);
            resDTO.setGuestPerson(guestDto);
            regDto.setRoom(nrmDto);
            regDto.setPerson(perDto);
            regDto.setReservation(resDTO);
            
            regDTOList.add(regDto);
        }
        
        try {
            return JSONHelper.getInstance().serialize(regDTOList);
        } catch (JsonProcessingException ex) {
            java.util.logging.Logger.getLogger(RoomGanttChartManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
