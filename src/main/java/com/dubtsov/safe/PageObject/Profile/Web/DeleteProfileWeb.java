package com.dubtsov.safe.PageObject.Profile.Web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Map.Web.MapPageWeb;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 21.12.17.
 */
public class DeleteProfileWeb {

    private String path = "body > app-root > content-component > profile-card-component > ";

    private MapPage mapPage;

    private SelenideElement passwordField = $(By.name("password"));

    private SelenideElement okButton = $(By.cssSelector(path + "profile-card-remove > div > div > button:nth-child(2)"));

    private SelenideElement cancelButton = $(By.cssSelector(path + "profile-card-remove > div > div > button:nth-child(1)"));

    private SelenideElement successWindowConfirmButton = $(By.cssSelector(path + "profile-card-success > div > div > button"));

    public MapPage deleteProfile() throws InterruptedException {
        mapPage = new MapPage(new MapPageWeb());
        mapPage.getProfilesList().first().findElementByXPath("div[2]").click();
        mapPage.getContextMenuCommandsList().find(Condition.matchesText("Удалить устройство")).click();
        passwordField.sendKeys("qqqqqq");
        okButton.click();
        successWindowConfirmButton.shouldBe(Condition.visible);
        successWindowConfirmButton.click();
        return new MapPage(new MapPageWeb());
    }

}
