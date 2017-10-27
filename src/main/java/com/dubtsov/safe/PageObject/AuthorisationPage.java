package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by user on 25.10.17.
 */
public class AuthorisationPage {

    final String  path = "/html/body/app-root/auth-component/div[2]";

    private SelenideElement login = $(By.name("auth_login"));

    private SelenideElement password = $(By.name("auth_pwd"));

    private SelenideElement recoverPassword = $(By.xpath(path + "/form/div"));

    private SelenideElement submitButton = $(By.xpath(path + "/form/button"));

    private SelenideElement registrationButton = $(By.xpath(path + "/p"));


    public MainScreenPage authorisationUser(String email, String pwd){
        login.setValue(email);
        password.setValue(pwd);
        submitButton.click();
        return new MainScreenPage();
    }

    public RegistrationStep1Page openRegistrationUserPage(){
        registrationButton.click();
        return new RegistrationStep1Page();
    }

    public RecoverPasswordPage openRecoverPasswordPage(){
        recoverPassword.click();
        return new RecoverPasswordPage();
    }


    public SelenideElement getLogin() {
        return login;
    }
    public SelenideElement getPassword() {
        return password;
    }
    public SelenideElement getRecoverPassword() {
        return recoverPassword;
    }
    public SelenideElement getSubmitButton() {
        return submitButton;
    }
    public SelenideElement getRegistrationButton() {
        return registrationButton;
    }
}
