package com.dubtsov.safe.PageObject.LinkActivationAccount;

import com.dubtsov.safe.GenerateTestData.GenerateEmail;
import com.dubtsov.safe.ApiMethods.GetCodeActivationAccount.GetCodeActivationAccount;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 27.10.17.
 */
public class LinkActivationAccount {

    public String getCodeRegistration() throws Exception {
        GetCodeActivationAccount getCodeActivationAccount = new GetCodeActivationAccount();
        String email = GenerateEmail.emailStatic;
        String code = String.valueOf(getCodeActivationAccount.getCode(email).getAct_code());
        return code;
    }

    public void registrationLinkClick() throws Exception {
        GetCodeActivationAccount getCodeActivationAccount = new GetCodeActivationAccount();
        String email = GenerateEmail.emailStatic;
        String code = String.valueOf(getCodeActivationAccount.getCode(email).getAct_code());
        String linkConfirmRegistration = "https://preprod.safe.com.ru/activate?em=" + email + "&code=" + code;
        open(linkConfirmRegistration);
    }
}
