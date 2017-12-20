package com.dubtsov.safe.ApiMethods.AuthorisationUser;

import com.dubtsov.safe.GenerateTestData.GenerateEmail;
import com.dubtsov.safe.Response.ResponseClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Created by user on 20.12.17.
 */
public class AuthorisationUser {

    public void authorisationUser() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", "ui_test217@p33.org");
        jsonObject.put("pwd", "qqqqqq");
        ResponseClass responseClass = new ResponseClass("https://api.safec.ru/os_api/accounts/v1.0/auth", jsonObject);
        responseClass.getJsonResponse();
    }
}
