package com.dubtsov.safe.ApiMethods.DeleteAccount;

import com.dubtsov.safe.Response.ResponseClass;
import com.squareup.okhttp.Response;
import org.json.simple.JSONObject;

import java.io.IOException;

/**
 * Created by user on 20.12.17.
 */
public class DeleteAccountClass {

    JSONObject jsonObject;

    public DeleteAccountClass() throws IOException {}

    public void deleteUser() throws Exception {
        jsonObject = GenerateRegisteredUsersContent.deleteAccountContent();
        ResponseClass responseClass = new ResponseClass("https://admin.preprod.safe.com.ru/os_api/accounts/v1.0/delete_account", jsonObject);
        responseClass.getJsonResponse();
    }

}
