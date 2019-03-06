package com.sapient.feecalc.services.utils;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

	public static Logger logger = LogManager.getLogger(JsonConverter.class.getName());

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static String toJson(Object object)
    {
    	try {
    		return MAPPER.writeValueAsString(object);
    	}catch(Exception ex) {
    		logger.info("Unable to convert to json");
    	}
        return "";
    }

    public static <T> T toObject(String str, Class<T> classType) throws IOException
    {
        T t = null;
        t = MAPPER.readValue(str, classType);
        return t;
    }   

	
}
