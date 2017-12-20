package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by user on 20.12.17.
 */
public class RegistrationStep5_2Page {

    String path = "body > app-root > main-activate-component > activate-school-component > div > div > ";

    private SelenideElement inputFild = $(By.cssSelector(path + "div.new-device__step2-search > input"));

    private List<SelenideElement> schoolList = $$(By.cssSelector(path + "div.new-device__step2-search > div > div"));

    private SelenideElement classField = $(By.cssSelector(path + "div.new-device__step2-class-select > input:nth-child(2)"));

    private SelenideElement wordField = $(By.cssSelector(path + "div.new-device__step2-class-select > input:nth-child(4)"));

    private SelenideElement cancelButton = $(By.cssSelector(path + "div.new-device__btn-block > div:nth-child(1) > p"));

    private SelenideElement successButton = $(By.cssSelector("div.new-device__btn-block > div:nth-child(2) > p"));

    public MapPage selectSchoolConfirm() throws InterruptedException {
        inputFild.click();
        schoolList.get(1).click();
        classField.setValue("11");
        wordField.setValue("А");
        successButton.click();
        return new MapPage();
    }

}
