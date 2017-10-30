package com.dubtsov.safe.OnlineSim;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by user on 30.10.17.
 */
public class NumModel {

    private String response;

    private String tzid;


    private JSONParser parser;
    private Object obj;
    private JSONObject jsonObj;

    public NumModel(String jsonObjectString) throws ParseException, java.text.ParseException {
        setObject(jsonObjectString);
    }

    private void setObject(String jsonObjectString) throws ParseException, java.text.ParseException {
        parser = new JSONParser();
        obj = parser.parse(jsonObjectString);
        jsonObj = (JSONObject) obj;

        try {
            if (jsonObj.get("response") != null) { setResponse(jsonObj.get("response").toString()); } else{setResponse(null);}
            if (jsonObj.get("tzid") != null) { setTzid(jsonObj.get("tzid").toString()); } else{setTzid(null);}
        } catch (Exception e){
            setResponse(null);
            setTzid(null);
        }
    }

    @Override
    public String toString() {
        return "NumModel{" +
                "response='" + response + '\'' +
                ", tzid='" + tzid + '\'' +
                '}';
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTzid() {
        return tzid;
    }

    public void setTzid(String tzid) {
        this.tzid = tzid;
    }
}
