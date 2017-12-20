package com.dubtsov.safe.ApiMethods.DeleteAccount;

import org.json.simple.JSONObject;

import java.util.Random;

/**
 * Created by user on 12.09.17.
 */
public class GenerateRegisteredUsersContent {

    public static JSONObject deleteAccountContent() throws Exception {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("pwd", "qqqqqq");
        return jsonObj;
    }

}
