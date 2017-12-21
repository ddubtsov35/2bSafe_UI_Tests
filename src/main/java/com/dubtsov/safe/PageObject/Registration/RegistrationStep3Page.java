package com.dubtsov.safe.PageObject.Registration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.Authorisation.AuthorisationPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 27.10.17.
 */
public class RegistrationStep3Page {

    private String path = "/html/body/app-root/main-activate-component/activate-component/div[2]";

    private SelenideElement button = $(By.xpath(path + "/button"));

    private SelenideElement message = $(By.xpath(path + "/p"));

    public RegistrationStep4Page successButtonClick() throws InterruptedException {
        //SwitchHandles.switchHandle();
        message.shouldHave(Condition.text("Регистрация завершена"));
        button.click();
        return new RegistrationStep4Page();
    }

    public AuthorisationPage failButtonClick(){
        message.shouldHave(Condition.text("Истекло время подтверждения аккаунта"));
        button.click();
        return new AuthorisationPage();
    }
}
