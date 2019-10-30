/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.managers.gn;

import com.summerregion.webapps.hms.dto.gn.UserDTO;
import com.summerregion.webapps.hms.models.gn.User;
import javax.ejb.Local;

/**
 *
 * @author LENOVO
 */
@Local
public interface IUserManager  {
    
    public User loginUser(UserDTO u);
}
