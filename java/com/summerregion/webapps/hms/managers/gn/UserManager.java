/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.managers.gn;

import com.summerregion.webapps.hms.dto.gn.UserDTO;
import com.summerregion.webapps.hms.models.gn.User;
import java.util.HashMap;
import javax.ejb.Stateless;
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
public class UserManager implements IUserManager {

    @PersistenceContext
    EntityManager mgr;

    //@ILoggable
    Logger logger = LoggerFactory.getLogger(UserManager.class);
    
//    private final String DEF_PWD="PASSWORD123";
    


    @Override
    public User loginUser(UserDTO u) {
        try {
            TypedQuery<User> q = mgr.createNamedQuery("tryLoginQuery", User.class);
            q.setParameter("usr", u.getUserId().toUpperCase());
            q.setParameter("pwd", u.getUserPassword());
            return q.getSingleResult();
        } catch(Exception e) {
            return null;
        }
    }

}
