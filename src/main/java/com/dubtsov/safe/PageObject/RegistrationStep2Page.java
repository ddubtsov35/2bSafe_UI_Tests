package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 27.10.17.
 */
public class RegistrationStep2Page {

    private SelenideElement resendEmailButton = $(By.linkText("Отправить письмо повторно"));

    public RegistrationStep2Page resendEmail(){
        resendEmailButton.click();
        return new RegistrationStep2Page();
    }

}
