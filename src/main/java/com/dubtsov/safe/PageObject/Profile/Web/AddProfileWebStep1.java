package com.dubtsov.safe.PageObject.Profile.Web;

import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep1Template;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 21.12.17.
 */
public class AddProfileWebStep1 extends AddProfileStep1Template{

    public AddProfileWebStep1(){
        super.path = "body > app-root > content-component > activate-component-device > div > div > div > div > ";
        super.successButton = $(By.cssSelector(path + "div:nth-child(2) > p"));
        super.skipButton = $(By.cssSelector(path + "div:nth-child(1) > p"));
    }

}
