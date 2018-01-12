package com.dubtsov.safe.PageObject.Zone;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import javax.xml.bind.SchemaOutputResolver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by user on 25.12.17.
 */
public class ZoneClass {

    private String pathCss = "body > app-root > content-component > ";

    private String pathXpath = "/html/body/app-root/content-component/";

    private SelenideElement sidebarButton = $(By.cssSelector(pathCss + "header-component > div > div.btn-menu"));

    private SelenideElement sidebarZoneButton = $(By.cssSelector(pathCss + "menu-component > div > div.menu__btn-block > div:nth-child(1) > p"));

    private SelenideElement addZoneButton = $(By.cssSelector(pathCss + "zones-view-component > div > div.map-zones-view__title-block > div.add.alma-icon-plus"));

    private SelenideElement closeZoneWindowButton = $(By.cssSelector(pathCss + "zones-view-component > div > div.map-zones-view__title-block > div.close.alma-icon-close"));

    private SelenideElement hintButton = $(By.cssSelector(pathCss + "zones-view-component > div.settings-success-container > div > div > button"));

    private SelenideElement radiusMarkerZone = $(By.cssSelector(pathCss + "zones-view-component > zone-create > div > div.device-add-zone__set-radius-block > div.marker"));

    private SelenideElement addressZone = $(By.cssSelector(pathCss + "zones-view-component > zone-create > div > div.geo-block > input"));

    private SelenideElement authorizedZone = $(By.cssSelector(pathCss + "zones-view-component > zone-create > div > div.select-type > div:nth-child(3) > label > span"));

    private SelenideElement notAuthorizedZone = $(By.cssSelector(pathCss + "zones-view-component > zone-create > div > div.select-type > div:nth-child(4) > label > span"));

    private SelenideElement cancelButton = $(By.cssSelector(pathCss + "zones-view-component > zone-create > div > div.device-add-zone__btn-block > button:nth-child(1)"));

    private SelenideElement okButton = $(By.cssSelector(pathCss + "zones-view-component > zone-create > div > div.device-add-zone__btn-block > button:nth-child(2)"));

    private SelenideElement confirmAddZoneButton = $(By.cssSelector(pathCss + "zones-view-component > zone-success > div > div > button"));

    private ElementsCollection zoneList = $$(By.xpath(pathXpath + "zones-view-component/div/div[2]/div[1]/div"));

    private SelenideElement confirmDeleteZoneButton = $(By.cssSelector("zones-view-component > zones-zone-remove > div > div > button:nth-child(2)"));


    public ZoneClass addZone(){

        System.out.println("1");
        if(!sidebarZoneButton.has(Condition.visible)) {
            sidebarButton.click();
        }
        sidebarZoneButton.shouldBe(Condition.visible);
        sidebarZoneButton.click();
        System.out.println("2");
        addZoneButton.shouldBe(Condition.visible);
        addZoneButton.click();
        System.out.println("3");
        Selenide.actions().moveByOffset((WebDriverRunner.getWebDriver().manage().window().getSize().getWidth())/2, (WebDriverRunner.getWebDriver().manage().window().getSize().getHeight())/2).perform();
        Selenide.actions().clickAndHold().perform();
        Selenide.actions().release().perform();
        System.out.println("4");
        okButton.shouldBe(Condition.visible);
        okButton.click();
        System.out.println("5");
        confirmAddZoneButton.shouldBe(Condition.visible);
        confirmAddZoneButton.click();
        System.out.println("6");
        return new ZoneClass();
    }

    public Integer getZoneListSize() throws InterruptedException {
        if(!sidebarZoneButton.has(Condition.visible)) {
            sidebarButton.click();
        }
        sidebarZoneButton.click();
        addZoneButton.shouldBe(Condition.visible);
        Thread.sleep(2000);
        ElementsCollection list;
        try {
            list = zoneList;
        } catch (Exception e){
            return 0;
        }
        return list.size();
    }

    public ZoneClass deleteZone(){
        if(!sidebarZoneButton.has(Condition.visible)) {
            sidebarButton.click();
        }
        sidebarZoneButton.click();
        addZoneButton.shouldBe(Condition.visible);
        System.out.println("List " + zoneList.size());
        zoneList.first().findElementByXPath("div[3]").click();
        confirmDeleteZoneButton.shouldBe(Condition.visible);
        confirmDeleteZoneButton.click();
        confirmAddZoneButton.shouldBe(Condition.visible);
        confirmAddZoneButton.click();
        closeZoneWindowButton.click();
        return new ZoneClass();
    }

    public void closeZonesWindow(){
        closeZoneWindowButton.click();
    }
}
