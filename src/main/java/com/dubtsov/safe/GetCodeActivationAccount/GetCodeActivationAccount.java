package com.dubtsov.safe.GetCodeActivationAccount;

import com.dubtsov.safe.Response.ResponseClass;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * Created by user on 30.10.17.
 */
public class GetCodeActivationAccount {

    public GetCodeActivationAccount() throws IOException {}

    public String adminAuthorisation() throws Exception {
        JSONObject jsonObject = GenerateAuthorisationAdminContent.getHeadersString();
        ResponseClass responseClass = new ResponseClass("http://admin.safec.ru/os_api/admin/v1.0/login", jsonObject);
        return responseClass.getJsonResponse().headers().toString();
    }

    public CodeActivationAccountModel getCode(String email) throws Exception {
        adminAuthorisation();
        JSONObject jsonObject = new GenerateContent().getContent(email);
        ResponseClass responseClass = new ResponseClass("http://admin.safec.ru/os_api/admin/v1.0/accounts_code", jsonObject);
        return new GetCodeActivation().getActCode(responseClass.getJsonResponse().body().string());
    }

}
