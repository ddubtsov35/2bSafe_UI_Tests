package com.dubtsov.safe.GetCodeActivationAccount;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.xbill.DNS.EDNSOption;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 30.10.17.
 */
public class GetCodeActivation {

    private CodeActivationAccountModel codeActivationAccountModel;

    public CodeActivationAccountModel getActCode(String userModelString) throws ParseException, java.text.ParseException {
        try {
            codeActivationAccountModel = new CodeActivationAccountModel(userModelString);
        } catch (ParseException e){}
        finally {
            return codeActivationAccountModel;
        }
    }

}
