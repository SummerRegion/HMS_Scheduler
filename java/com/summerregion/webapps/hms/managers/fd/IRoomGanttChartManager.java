/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.managers.fd;

import com.summerregion.webapps.hms.dto.fd.RegistrationDTO;
import com.summerregion.webapps.hms.dto.gn.RoomDTO;

/**
 *
 * @author LENOVO
 */
public interface IRoomGanttChartManager {
    public String searchRoomGanttChart(RoomDTO rDTO);
    public String searchGanttChartEvent(RegistrationDTO rDTO);
    
}
