/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.managers.gn;


import com.summerregion.webapps.hms.models.gn.CodeLines;
import java.util.List;
//import java.util.Set;
import javax.ejb.Local;

/**
 *
 * @author Faizul (zulcomp) Ngsrimin
 */
@Local
public interface ICodeManager {
    
    public List<CodeLines> retrieveCodeLinesByCode(String code);
    public List<CodeLines> retrieveCodeLines(String cdCode, String clCode);
}
