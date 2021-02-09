/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tms.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 *
 * @author thiago.meinel
 */
@Service
public class JsonUtil {

    public JSONObject stringToJson(String[] array) {
        
        

        JSONObject obj = new JSONObject();
        obj.put("logic", Integer.parseInt(array[0]));
        obj.put("serial", array[1]);
        obj.put("model", array[2]);
        obj.put("sam", Integer.parseInt(array[3]));
        obj.put("ptid", array[4]);
        obj.put("plat", Integer.parseInt(array[5]));
        obj.put("version", array[6]);
        obj.put("mxr", Integer.parseInt(array[7]));
        obj.put("mxf", array[8]);
        if (array.length == 10) {
            obj.put("verfm", array[9]);
        }

        return obj;
    }
}
