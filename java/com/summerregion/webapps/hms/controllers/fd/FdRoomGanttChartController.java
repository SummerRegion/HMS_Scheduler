/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.controllers.fd;

import com.summerregion.webapps.hms.annotation.Compress;
import com.summerregion.webapps.hms.dto.fd.RegistrationDTO;
import com.summerregion.webapps.hms.dto.gn.RoomDTO;
//import com.summerregion.webapps.hms.helper.DTOHelper;
import com.summerregion.webapps.hms.helper.JSONHelper;
import com.summerregion.webapps.hms.managers.fd.IRoomGanttChartManager;
import java.io.IOException;
//import java.net.MalformedURLException;
//import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author LENOVO
 */
@Path("roomganttchart")
public class FdRoomGanttChartController {
    

    @Context
    private UriInfo context;
    
    @Context
    HttpServletRequest request;

    
    @Inject
    private IRoomGanttChartManager mgr;
    
    Logger logger = LoggerFactory.getLogger(FdRoomGanttChartController.class);
    
    /**
     * Creates a new instance of GnRoomController
     */
    public FdRoomGanttChartController() {
    }

    /**
     * Retrieves representation of an instance of com.summerregion.webapps.hms.controllers.gn.GnRoomController
     * @param content
     * @return an instance of java.lang.String
     */
    
    @GET
    @Compress
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchRoom(@QueryParam(value = "q") String content) {
        String serializeObj = "()";
        
//        JSONHelper jh = JSONHelper.getInstance();
//        DTOHelper dh = DTOHelper.getInstance();
        
        try {
            RoomDTO rDto = (RoomDTO) JSONHelper.getInstance().deserialize(content, RoomDTO.class);

            serializeObj = mgr.searchRoomGanttChart(rDto);
        } catch (IOException | SecurityException | IllegalArgumentException ex) {
            logger.error(ex.getMessage());
            serializeObj = "{\"error\":\""+"Internal Error" +"\"}";
        }
       
       return serializeObj;
    }
    
    @GET
    @Compress
    @Path("/event")
    @Produces(MediaType.APPLICATION_JSON)
    public String searchEvent(@QueryParam(value = "q") String content) {
        String serializeObj = "()";
        
//        JSONHelper jh = JSONHelper.getInstance();
//        DTOHelper dh = DTOHelper.getInstance();
        
        try {
            RegistrationDTO rDto = (RegistrationDTO) JSONHelper.getInstance().deserialize(content, RegistrationDTO.class);

            serializeObj = mgr.searchGanttChartEvent(rDto);
        } catch (IOException | SecurityException | IllegalArgumentException ex) {
            logger.error(ex.getMessage());
            serializeObj = "{\"error\":\""+"Internal Error" +"\"}";
        }
       
       return serializeObj;
    }
}
