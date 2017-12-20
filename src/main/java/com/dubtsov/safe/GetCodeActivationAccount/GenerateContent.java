package com.dubtsov.safe.GetCodeActivationAccount;

import org.json.simple.JSONObject;

/**
 * Created by user on 19.12.17.
 */
public class GenerateContent {

    private JSONObject jsonObject;

    public JSONObject getContent(String email){
        jsonObject = new JSONObject();

        jsonObject.put("email", email);

        return jsonObject;
    }

}
