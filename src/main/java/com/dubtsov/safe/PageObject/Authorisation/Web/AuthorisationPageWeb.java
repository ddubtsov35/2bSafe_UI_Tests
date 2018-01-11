package com.dubtsov.safe.PageObject.Authorisation.Web;

import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Map.Web.MapPageWeb;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep1Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by user on 25.10.17.
 */
public class AuthorisationPageWeb {

    protected String  path = "body > app-root > auth-component > div.auth > ";

    protected SelenideElement login = $(By.name("auth_login"));

    protected SelenideElement password = $(By.name("auth_pwd"));

    protected SelenideElement recoverPassword  = $(By.cssSelector(path + "form > div"));

    protected SelenideElement submitButton = $(By.cssSelector(path + "form > button"));

    protected SelenideElement registrationButton = $(By.cssSelector(path + "p"));


    public MapPage authorisationUser(String email, String pwd){
        login.setValue(email);
        password.setValue(pwd);
        submitButton.click();
        return new MapPage(new MapPageWeb());
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
