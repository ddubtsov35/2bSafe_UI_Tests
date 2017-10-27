package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 27.10.17.
 */
public class RegistrationStep3Page {

    private SelenideElement successNextButton = $(By.name("далее"));

    private SelenideElement failButton = $(By.name("назад"));

    private SelenideElement successMessage = $(By.className("activate"));

    private SelenideElement failMessage = $(By.name("Истекло время подтверждения аккаунта"));

    public RegistrationStep4Page successButtonClick(){
        successMessage.shouldBe(Condition.visible);
        successNextButton.click();
        return new RegistrationStep4Page();
    }

    public AuthorisationPage failButtonClick(){
        failMessage.shouldBe(Condition.visible);
        failButton.click();
        return new AuthorisationPage();
    }
}
