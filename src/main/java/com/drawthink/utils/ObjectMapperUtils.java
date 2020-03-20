package com.drawthink.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author fangchen
 * @date 2020/3/15 10:43 下午
 */
public class ObjectMapperUtils {
    private static final ObjectMapper Mapper=new ObjectMapper();


    //将目标类转化为json
    public static String toJson(Object target){


        String json=null;
        try{
            json =Mapper.writeValueAsString(target );
        }catch (Exception e){//将检查异常转化为运行时异常
            e.printStackTrace();
            throw new RuntimeException();
        }
        return json;
    }
    public static <T> T  toObject(String json,Class<T> target) throws IOException {
        T t = null;
        try {
            t = Mapper.readValue(json, target);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return t;
    }
}

