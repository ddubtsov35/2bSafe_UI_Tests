package com.dubtsov.safe.PageObject.Profile.Web;

import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep2Template;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by user on 21.12.17.
 */
public class AddProfileWebStep2 extends AddProfileStep2Template{

    public AddProfileWebStep2(){
        super.path = "body > app-root > content-component > activate-school-component > div > div > ";
        super.inputFild = $(By.cssSelector(path + "div.new-device__step2-search > input"));
        super.schoolList = $$(By.cssSelector(path + "div.new-device__step2-search > div > div"));
        super.classField = $(By.cssSelector(path + "div.new-device__step2-class-select > input:nth-child(2)"));
        super.wordField = $(By.cssSelector(path + "div.new-device__step2-class-select > input:nth-child(4)"));
        super.cancelButton = $(By.cssSelector(path + "div.new-device__btn-block > div:nth-child(1) > p"));
        super.successButton = $(By.cssSelector(path + "div.new-device__btn-block > div:nth-child(2) > p"));
    }

}
