/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.dto.gn;

import java.util.List;

/**
 *
 * @author Faizul (zulcomp) Ngsrimin
 */
public class CodeLineDTO {
    
    private Long clId;
    private String clCode;
    private String clDescription;
    private String activeInd;
    private String defaultInd; 
    private String cdCode;
    private String systemInd;
    private Integer sequenceNo;
//    private CodesDTO code;

//    private List<CodesDTO> lstCode;
    
    public Long getClId() {
        return clId;
    }

    public void setClId(Long clId) {
        this.clId = clId;
    }

    public String getClCode() {
        return clCode;
    }

    public void setClCode(String clCode) {
        this.clCode = clCode;
    }

    public String getClDescription() {
        return clDescription;
    }

    public void setClDescription(String clDescription) {
        this.clDescription = clDescription;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }

    public String getDefaultInd() {
        return defaultInd;
    }

    public void setDefaultInd(String defaultInd) {
        this.defaultInd = defaultInd;
    }
    
    public String getCdCode() {
        return cdCode;
    }

    public void setCdCode(String cdCode) {
        this.cdCode = cdCode;
    }

//    public CodesDTO getCode() {
//        return code;
//    }
//
//    public void setCode(CodesDTO code) {
//        this.code = code;
//    }
//
//    public List<CodesDTO> getLstCode() {
//        return lstCode;
//    }
//
//    public void setLstCode(List<CodesDTO> lstCode) {
//        this.lstCode = lstCode;
//    }

    public String getSystemInd() {
        return systemInd;
    }

    public void setSystemInd(String systemInd) {
        this.systemInd = systemInd;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

}
