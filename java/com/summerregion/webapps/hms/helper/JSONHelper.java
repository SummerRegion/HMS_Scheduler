/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.summerregion.webapps.hms.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class JSONHelper {
    
    private final ObjectMapper mapper;
    
    private static class JSONHelperHolder {
        private static final JSONHelper INSTANCE = new JSONHelper();
    }
    
    private JSONHelper() {
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false);
    }
    
    public static JSONHelper getInstance() {
        return JSONHelperHolder.INSTANCE;
    }
    
    public String serialize(List<Object> list) throws JsonProcessingException {
        return mapper.writeValueAsString(list);
    }
    
    public String serialize(Object o) throws JsonProcessingException {
        return mapper.writeValueAsString(o);
    }
    
    public Object deserialize(String json, Class clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }
    
    public ObjectMapper getMapper() {
        return mapper;
    }
}
