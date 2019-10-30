/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import net.sf.cglib.beans.BeanGenerator;

/**
 *
 * @author LENOVO
 */
public class DTOHelper {

    private static class DTOHelperHolder {

        private static final DTOHelper INSTANCE = new DTOHelper();
    }

    private DTOHelper() {
    }

    public static DTOHelper getInstance() {
        return DTOHelperHolder.INSTANCE;
    }
    public List<?> generateDTOList(Class<?> clazz, List<?> list, HashMap<String, String> attrMapSrcDes) {
        
        // automatically add version fields
        if(!attrMapSrcDes.containsKey("version")) attrMapSrcDes.put("version", "version");
        
        List outList = new ArrayList();
        
        for (int i = 0,le = list.size(); i < le ; i++) {
            Object o = generateDTO(list.get(i), clazz, attrMapSrcDes);
            if (o != null) {
                outList.add(o);
            }
        }

        return outList;
    }
        
    public Object generateDTO(Object objIn, Class<?> clazzOut, HashMap<String, String> attrMapSrcDes) {
        if(!attrMapSrcDes.containsKey("version")) attrMapSrcDes.put("version", "version");
        try {
            Constructor<?> ctor = clazzOut.getConstructor((Class<?>[]) null);
            Object object = ctor.newInstance();

            updateSrcDescAttributes(objIn, object, attrMapSrcDes);
            return object;

        } catch (IllegalAccessException
                | IllegalArgumentException | InstantiationException
                | NoSuchMethodException | SecurityException
                | InvocationTargetException e) {

        }
        return null;
    }

    public void updateSrcDescAttributes(Object src, Object des,
            HashMap<String, String> attrMapSrcDes) {

        //List<Field> srcFields = (List<Field>) itrMap.get(src.getClass().getName());
        //if (srcFields == null) {
        //Set<String> attr = attrMapSrcDes.keySet().stream().filter((String p) -> {
        //    return !p.contains(".");
        //}).collect(Collectors.toSet());
        if(!attrMapSrcDes.containsKey("version")) attrMapSrcDes.put("version", "version");
        List<Field> srcFields = getFieldsUpTo(src.getClass(),attrMapSrcDes.keySet(), null);
        //    itrMap.put(src.getClass().getName(), srcFields);
        //}

        for (Field srcf : srcFields) {
            String attrDes = attrMapSrcDes.get(srcf.getName());
            if (attrDes != null && !"".equals(attrDes)) {
                StringBuilder desbuf = new StringBuilder(attrDes);
                desbuf.replace(0, 1, desbuf.substring(0, 1).toUpperCase());

                StringBuilder srcbuf = new StringBuilder(srcf.getName());
                srcbuf.replace(0, 1, srcbuf.substring(0, 1).toUpperCase());

                try {
                    Method desSetMethod = des.getClass().getDeclaredMethod("set" + desbuf.toString(), srcf.getType());
                    Method srcGetMethod = src.getClass().getDeclaredMethod("get" + srcbuf.toString());
                    Object srcGetResult = srcGetMethod.invoke(src);
                    desSetMethod.invoke(des, srcGetResult);
                } catch (IllegalAccessException | IllegalArgumentException
                        | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                }
            }
        }
    }

    public List<Field> getFieldsUpTo(Class<?> startClass, final Set<String> fField,
            Class<?> exclusiveParent) {
        List<Field> currentClassFields = Lists.newArrayList(startClass.getDeclaredFields());
        if (fField != null) {
            Predicate<Field> predicate = new Predicate<Field>() {
                @Override
                public boolean apply(Field input) {
                    return (fField.contains(input.getName()));
                }

                @Override
                public boolean test(Field t) {
                    return (fField.contains(t.getName()));
                }
            };
            currentClassFields = Lists.newArrayList(Collections2.filter(currentClassFields, predicate));
        }
        Class<?> parentClass = startClass.getSuperclass();

        if (parentClass != null
                && (exclusiveParent == null || !(parentClass.equals(exclusiveParent)))) {
            Iterable<Field> parentClassFields
                    = getFieldsUpTo(parentClass, fField, exclusiveParent);
            currentClassFields.addAll((Collection<? extends Field>) parentClassFields);
        }

        return currentClassFields;
    }

    public String serializeDynamicDTO(Object model, HashMap<String, Class> fields) {
        Object dto = this.createDynamicDTO(model, fields);

        try {
            String s = JSONHelper.getInstance().serialize(dto);
            return s;
        } catch (JsonProcessingException ex) {
            //Logger.getLogger(DTOHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Object createDynamicDTO(Object model, HashMap<String, Class> fields) {
        BeanGenerator beanGen = new BeanGenerator();
        //generate dto and add attribute
        for (String key : fields.keySet()) {
            beanGen.addProperty(key, (Class) fields.get(key));
        }

        Object obj = beanGen.create();
        //add value to dto from model if exists
        if (model != null) {
            
            for (String key : fields.keySet()) {
                StringBuilder srcbuf = new StringBuilder(key);
                srcbuf.replace(0, 1, srcbuf.substring(0, 1).toUpperCase());
                try {
                    Method setter = obj.getClass().getMethod("set" + srcbuf.toString(), (Class) fields.get(key));
                    Method getter = model.getClass().getMethod("get" + srcbuf.toString());

                    setter.invoke(obj, getter.invoke(model));

                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    // Logger.getLogger(DTOHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return obj;
    }

}
