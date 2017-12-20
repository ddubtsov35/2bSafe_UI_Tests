package com.dubtsov.safe.ApiMethods.GetCodeActivationAccount;

import org.json.simple.parser.ParseException;

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
