package com.dubtsov.safe.PageObject;

import com.dubtsov.safe.GenerateTestData.GenerateEmail;
import com.dubtsov.safe.ApiMethods.GetCodeActivationAccount.GetCodeActivationAccount;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 27.10.17.
 */
public class LinkActivationAccount {

    public void registrationLinkClick() throws Exception {
        GetCodeActivationAccount getCodeActivationAccount = new GetCodeActivationAccount();
        String email = GenerateEmail.emailStatic;
        String code = String.valueOf(getCodeActivationAccount.getCode(email).getAct_code());
        String linkConfirmRegistration = "https://lkdev.safec.ru/activate?em=" + email + "&code=" + code;
        open(linkConfirmRegistration);
    }
}
