package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.dubtsov.safe.SwitchHandles.SwitchHandles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 27.10.17.
 */
public class RegistrationStep3Page {

    private String path = "/html/body/app-root/activate-component/div[1]";

    private SelenideElement successNextButton = $(By.xpath(path + "/button"));

    private SelenideElement failButton = $(By.name("назад"));

    private SelenideElement successMessage = $(By.xpath(path + "/p"));

    private SelenideElement failMessage = $(By.name("Истекло время подтверждения аккаунта"));

    public RegistrationStep4Page successButtonClick() throws InterruptedException {
        SwitchHandles.switchHandle();
        successMessage.shouldHave(Condition.text("Регистрация завершена"));
        System.out.println("1");
        successNextButton.click();
        System.out.println("2");
        return new RegistrationStep4Page();
    }

    public AuthorisationPage failButtonClick(){
        failMessage.shouldBe(Condition.visible);
        failButton.click();
        return new AuthorisationPage();
    }
}
