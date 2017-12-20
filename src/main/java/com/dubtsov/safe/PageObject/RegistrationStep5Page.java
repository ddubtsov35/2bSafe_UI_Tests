package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 27.10.17.
 */
public class RegistrationStep5Page {

    private SelenideElement name = $(By.name("name"));

    private SelenideElement age = $(By.name("age"));

    private SelenideElement photo = $(By.name("file"));

    private SelenideElement phone = $(By.name("number"));

    private SelenideElement sendSms = $(By.name("send_sms"));

    private SelenideElement successButton = $(By.cssSelector("body > app-root > main-activate-component > activate-component-device > div > div > div > button"));

    private SelenideElement skipButton = $(By.partialLinkText("пропустить шаг"));

    public MapPage skipButtonClick(){
        skipButton.click();
        return new MapPage();
    }

    public RegistrationStep5_2Page successButtonClick(){
        name.setValue("Test");
        age.setValue("18");
        phone.setValue("1111111111");
        successButton.click();
        return new RegistrationStep5_2Page();
    }

}
