package com.dubtsov.safe.PageObject.Authorisation;

import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.MapPage;
import com.dubtsov.safe.PageObject.Registration.RegistrationStep1Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by user on 25.10.17.
 */
public class AuthorisationPage {

    final String  path = "body > app-root > auth-component > div.auth > ";

    private SelenideElement login = $(By.name("auth_login"));

    private SelenideElement password = $(By.name("auth_pwd"));

    private SelenideElement recoverPassword = $(By.cssSelector(path + "form > div"));

    private SelenideElement submitButton = $(By.cssSelector(path + "form > button"));

    private SelenideElement registrationButton = $(By.cssSelector(path + "p"));


    public MapPage authorisationUser(String email, String pwd){
        login.setValue(email);
        password.setValue(pwd);
        submitButton.click();
        return new MapPage();
    }

    public RegistrationStep1Page openRegistrationUserPage(){
        registrationButton.click();
        return new RegistrationStep1Page();
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
