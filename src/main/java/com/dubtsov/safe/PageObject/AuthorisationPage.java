package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by user on 25.10.17.
 */
public class AuthorisationPage {

    final String  path = "/html/body/app-root/auth-component/div[2]";

    private SelenideElement login = $(By.name("auth_login"));

    private SelenideElement password = $(By.name("auth_pwd"));

    private SelenideElement rememberPassword = $(By.xpath(path + "/form/div"));

    private SelenideElement submitButton = $(By.xpath(path + "/form/button"));

    private SelenideElement registrationButton = $(By.xpath(path + "/p"));


    public MainScreenPage authorisationUser(String email, String pwd){
        login.setValue(email);
        password.setValue(pwd);
        submitButton.click();
        return page(MainScreenPage.class);
    }

}
