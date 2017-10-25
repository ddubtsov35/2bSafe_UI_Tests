package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by user on 25.10.17.
 */
public class AuthorisationPage {

    final String  path = "/html/body/app-root/auth-component/div[2]";

    @FindBy(how = How.NAME, using = "auth_login")
    private SelenideElement login;

    @FindBy(how = How.NAME, using = "auth_pwd")
    private SelenideElement password;

    @FindBy(how = How.XPATH, using = path + "/form/div")
    private SelenideElement rememberPassword;

    @FindBy(how = How.XPATH, using = path + "/form/button")
    private SelenideElement submitButton;

    @FindBy(how = How.XPATH, using = path + "/p")
    private SelenideElement registrationButton;

    public MainScreenPage authorisationUser(String email, String pwd){
        login.setValue(email);
        password.setValue(pwd);
        submitButton.click();
        return page(MainScreenPage.class);
    }

}
