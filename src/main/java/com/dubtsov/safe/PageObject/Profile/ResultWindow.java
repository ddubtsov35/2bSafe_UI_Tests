package com.dubtsov.safe.PageObject.Profile;

import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.MapPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 21.12.17.
 */
public class ResultWindow {

    private SelenideElement okButton = $(By.cssSelector("body > app-root > content-component > settings-component > setting-success > div > div > button"));

    public MapPage confirm(){
        okButton.click();
        return new MapPage();
    }

}
