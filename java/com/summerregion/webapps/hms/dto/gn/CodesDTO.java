/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.dto.gn;

/**
 *
 * @author Administrator
 */
public class CodesDTO {
    
    private Long id;
    private String code;
    private String description;
    private String systemInd;
    private String activeInd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSystemInd() {
        return systemInd;
    }

    public void setSystemInd(String systemInd) {
        this.systemInd = systemInd;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }
}
