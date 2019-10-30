/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.managers.gn;

import com.summerregion.webapps.hms.models.gn.CodeLines;
import java.util.List;
//import java.util.Objects;
//import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import javax.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Faizul (zulcomp) Ngsrimin
 */
@Stateless
public class CodeManager implements ICodeManager {
    
    @PersistenceContext
    EntityManager mgr;
    
    //@ILoggable
    Logger logger = LoggerFactory.getLogger(CodeManager.class);
    

    @Override
    public List<CodeLines> retrieveCodeLinesByCode(String code) {
        Query q = mgr.createNamedQuery("retrieveCodeLinesByCode", CodeLines.class);
        q.setParameter("cdCode", code);
        return q.getResultList();
    }

    @Override
    public List<CodeLines> retrieveCodeLines(String cdCode, String clCode) {
        Query q = mgr.createNamedQuery("retrieveCodeLines", CodeLines.class);
        q.setParameter("cdCode", cdCode);
        q.setParameter("clCode", clCode);
        return q.getResultList();
    }
    

}
