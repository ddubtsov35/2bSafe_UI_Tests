package com.dubtsov.safe.ApiMethods.GetCodeActivationAccount;

import org.json.simple.JSONObject;

/**
 * Created by user on 19.12.17.
 */
public class GenerateAuthorisationAdminContent {

    public static JSONObject getHeadersString() throws Exception {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("em", "111@ru.ru");
        jsonObj.put("pwd", "3,14plsvtijr");
        return jsonObj;
    }

}
