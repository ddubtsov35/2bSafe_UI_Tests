package com.dubtsov.safe.PageObject.Registration;

import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep1Template;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 27.10.17.
 */
public class RegistrationStep5Page extends AddProfileStep1Template {

    public RegistrationStep5Page(){
        super.path = "body > app-root > main-activate-component > activate-component-device > div > div > div > ";
        super.successButton = $(By.cssSelector(path + "button"));
        super.skipButton = $(By.cssSelector(path + "p"));
    }
}
