package com.dubtsov.safe.TempMail;

import com.dubtsov.safe.Response.ResponseClass;

import java.util.List;

/**
 * Created by user on 30.10.17.
 */
public class TempMailClass {

    public ResponseClass responseClass;

    public List<MailModel> getMail() throws Exception {
        responseClass = new ResponseClass("http://api.temp-mail.ru/request/mail/id/e0cf6d1c89594268236b4768607cea5e/format/json/");
        return GetMail.getMail(responseClass.getJsonResponse().body().string());
    }

}
