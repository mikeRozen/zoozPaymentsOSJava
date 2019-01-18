/*
 * MIT License
 *
 * Copyright (c) 2018 mikeRozen
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.dogiz.zoozpaymentsos.control;

import com.dogiz.zoozpaymentsos.beans.Customer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Michael
 */
public class JsonParser {
    private static Gson gson = null;
    static{
        gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }
    
    public static String toJson(Object obj){
        if (obj == null ){return null;}
        return gson.toJson(obj);
    }
    
    public static String toJsonRoot(Object obj){
        if (obj == null ){return null;}
        JsonObject jsonObj = new JsonObject();
        JsonElement jsonElement = gson.toJsonTree(obj);
        String className = obj.getClass().getSimpleName();
        String classNameSnakeCase = className.replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();
        jsonObj.add(classNameSnakeCase, jsonElement);
        return jsonObj.toString();
    }
    
    public static <T>  List<T> fromJsonArray(String json,Class<T[]> clazz){
        try {
            //Type listType = new TypeToken<ArrayList<T>>(){}.getType();
            //return gson.fromJson(json, TypeToken.get(new ArrayList<T>().getClass()));
            //Work Around: On run time gson cant/link or find the class --- Strange  
            T[] arr = gson.fromJson(json, clazz);
            return Arrays.asList(arr);
        } catch (Exception e) {
            System.out.println("fromJsonList Error: " + e.getMessage());
        }
        return null;
    }
            
    public static <T extends Object>  T fromJson(String json, Class<T> classOfT){
        try{
            return gson.fromJson(json, classOfT);
        }catch(Exception e){
            System.out.println("fromJson Error: " + e.getMessage());
        }
        return null;
    }
    
}
