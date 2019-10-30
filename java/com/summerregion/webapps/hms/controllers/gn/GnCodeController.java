/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.controllers.gn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.summerregion.webapps.hms.dto.gn.CodeLineDTO;
import com.summerregion.webapps.hms.helper.DTOHelper;
import com.summerregion.webapps.hms.helper.JSONHelper;
import com.summerregion.webapps.hms.managers.gn.ICodeManager;
import com.summerregion.webapps.hms.models.gn.CodeLines;
//import java.io.IOException;
//import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
//import java.util.Set;
import java.util.concurrent.ExecutorService;
//import java.util.logging.Level;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST Web Service
 *
 * @author Faizul (zulcomp) Ngsrimin
 */
@Path("code")
@RequestScoped
public class GnCodeController {

    @Context
    private UriInfo context;

    @Context
    HttpServletRequest request;

    @Inject
    ICodeManager codeMgr;

    //@ILoggable
    Logger logger = LoggerFactory.getLogger(GnCodeController.class);
    
    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();
    

    /**
     * Creates a new instance of CodeController
     */
    public GnCodeController() {
    }

    /**
     * PUT method for updating or creating an instance of CodeController
     *
     * @param content representation for the resource
     * @return 
     */

    
    @GET
    @Path(value = "/{code}/")
    @Produces(value = MediaType.APPLICATION_JSON)
    public String getCodeLines(@PathParam(value = "code") final String code) {
    
        String jsonObj = "{}";
        HashMap attrMap = new HashMap<String, String>() {
            {
                put("id", "clId");
                put("code", "clCode");
                put("description", "clDescription");
                put("activeInd", "activeInd");
                put("defaultInd", "defaultInd");
            }
        };
        List<CodeLines> codeLines = codeMgr.retrieveCodeLinesByCode(code);
        List<CodeLineDTO> codelineDtoList = (List<CodeLineDTO>) DTOHelper.getInstance()
                .generateDTOList(CodeLineDTO.class, (List<?>) codeLines, attrMap);

        try {
            jsonObj = JSONHelper.getInstance().serialize(codelineDtoList);
        } catch (JsonProcessingException ex) {
                logger.error(ex.getMessage());
        }
        return jsonObj;
    }
    
    @GET
    @Path(value = "/{code}/{codeline}/")
    @Produces(value = MediaType.APPLICATION_JSON)
    public String getSingleCodeLine(@PathParam(value = "code") final String code, @PathParam(value = "codeline") final String codeline) {
    
        String jsonObj = "{}";
        HashMap attrMap = new HashMap<String, String>() {
            {
                put("id", "clId");
                put("code", "clCode");
                put("description", "clDescription");
                put("activeInd", "activeInd");
                put("defaultInd", "defaultInd");
            }
        };
        
        List<CodeLines> codeLines = codeMgr.retrieveCodeLines(code,codeline);
        List<CodeLineDTO> codelineDtoList = (List<CodeLineDTO>) DTOHelper.getInstance()
                    .generateDTOList(CodeLineDTO.class, (List<?>) codeLines, attrMap);

        try {
            jsonObj = JSONHelper.getInstance().serialize(codelineDtoList);
        } catch (JsonProcessingException ex) {
                logger.error(ex.getMessage());
        }
        
        return jsonObj;
    }

    
}
