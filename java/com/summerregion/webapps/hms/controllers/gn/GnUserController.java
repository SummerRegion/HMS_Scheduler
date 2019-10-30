/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.controllers.gn;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.summerregion.webapps.hms.dto.gn.UserDTO;
import com.summerregion.webapps.hms.helper.JSONHelper;
import com.summerregion.webapps.hms.managers.gn.IUserManager;
import com.summerregion.webapps.hms.models.gn.User;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST Web Service
 *
 * @author LENOVO
 */
@Path("/users")
public class GnUserController {

    @Context
    private UriInfo context;

    @Context
    HttpServletRequest request;

    @Inject
    IUserManager userManager;
    
    //@ILoggable
    Logger logger = LoggerFactory.getLogger(GnUserController.class);

    /**
     * Creates a new instance of LoginController
     */
    public GnUserController() {
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String loginUser(String content) {
        String serObj = "{}";

        try {
            UserDTO uDto = (UserDTO) JSONHelper.getInstance().deserialize(content, UserDTO.class);
            User u = userManager.loginUser(uDto);

            if (u != null) {
                String actv= u.getActiveInd();
                if(actv!=null && !"".equals(actv) && !"N".equals(actv)) {
                Algorithm algorithm = Algorithm.HMAC256(request.getServletContext().getInitParameter("secret"));
                String token = JWT.create()
                        .withClaim("userKey", u.getId().toString())
                        .withClaim("userId", u.getUserId())
                        .withClaim("userName", u.getUserName())
                        .withIssuer("HMS")
                        .withIssuedAt(new Date())
                        .sign(algorithm);
                if (token != null && !"".equals(token)) {
                    serObj = "{\"token\":\"" + token + "\"}";
                } else {
                    serObj = "{\"error\":\"" + "Internal Error" + "\"}";
                }
                } else {
                    serObj = "{\"error\":\"" + "Internal Error" + "\"}";
                }
            } else {
                serObj = "{\"error\":\"" + "Internal Error" + "\"}";
            }
        } catch (IOException | JWTCreationException ex) {
            logger.error(ex.getMessage());
            serObj = "{\"error\":\"" + "Internal Error" + "\"}";
        } catch (EJBException ex2) {
            serObj = "{\"error\":\"" + "Internal Error" + "\"}";
        }
        return serObj;
    }
}
