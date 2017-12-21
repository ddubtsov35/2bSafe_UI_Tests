package com.dubtsov.safe.PageObject.Registration;

import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep2Template;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by user on 20.12.17.
 */
public class RegistrationStep5_2Page extends AddProfileStep2Template {

    public RegistrationStep5_2Page(){
        super.path = "body > app-root > main-activate-component > activate-school-component > div > div > ";
        super.inputFild = $(By.cssSelector(path + "div.new-device__step2-search > input"));
        super.schoolList = $$(By.cssSelector(path + "div.new-device__step2-search > div > div"));
        super.classField = $(By.cssSelector(path + "div.new-device__step2-class-select > input:nth-child(2)"));
        super.wordField = $(By.cssSelector(path + "div.new-device__step2-class-select > input:nth-child(4)"));
        super.cancelButton = $(By.cssSelector(path + "div.new-device__btn-block > div:nth-child(1) > p"));
        super.successButton = $(By.cssSelector(path + "div.new-device__btn-block > div:nth-child(2) > p"));
    }

}
