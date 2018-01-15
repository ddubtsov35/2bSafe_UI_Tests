package com.dubtsov.safe.PageObject.Registration.Web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.GenerateTestData.GenerateEmail;
import com.dubtsov.safe.PageObject.Authorisation.Web.AuthorisationPageWeb;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 27.10.17.
 */
public class RegistrationStep1Page {

    final String  path = "/html/body/app-root/reg-container/reg-component/div[2]";

    private SelenideElement login = $(By.name("auth_login"));

    private SelenideElement password = $(By.name("auth_pwd"));

    private SelenideElement confirmPassword = $(By.name("auth_pwd_repeat"));

    private SelenideElement submitButton = $(By.xpath(path + "/button"));

    private SelenideElement authorisationButton = $(By.xpath(path + "/p"));

    public AuthorisationPageWeb openAuthorisationUserPage(){
        authorisationButton.click();
        return new AuthorisationPageWeb();
    }

    public RegistrationStep2Page registration() throws IOException {
        String email = GenerateEmail.emailStatic;
        login.setValue(email);
        password.setValue("qqqqqq");
        confirmPassword.setValue("qqqqqq");
        submitButton.click();
        $(By.xpath("/html/body/app-root/reg-container/reg-component-success/div/div[2]/p[2]")).shouldBe(Condition.visible).shouldHave(Condition.text(""));
        return new RegistrationStep2Page();
    }
}
