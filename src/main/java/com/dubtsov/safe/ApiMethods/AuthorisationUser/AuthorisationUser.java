package com.dubtsov.safe.ApiMethods.AuthorisationUser;

import com.dubtsov.safe.GenerateTestData.GenerateEmail;
import com.dubtsov.safe.Response.ResponseClass;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * Created by user on 20.12.17.
 */
public class AuthorisationUser {

    public void authorisationUser(String login) throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", login);
        jsonObject.put("pwd", "qqqqqq");
        ResponseClass responseClass = new ResponseClass("https://admin.preprod.safe.com.ru/os_api/accounts/v1.0/auth", jsonObject);
        responseClass.getJsonResponse();
    }
}
