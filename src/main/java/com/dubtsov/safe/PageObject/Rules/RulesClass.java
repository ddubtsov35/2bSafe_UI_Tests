package com.dubtsov.safe.PageObject.Rules;

import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Map.Mobile.MapPageMobile;
import com.dubtsov.safe.PageObject.Map.Web.MapPageWeb;
import com.dubtsov.safe.PageObject.Profile.Web.AddProfileWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by user on 26.12.17.
 */
public class RulesClass {

    private String pathCss = "body > app-root > content-component > ";

    private String pathXpath = "/html/body/app-root/content-component/";

    private SelenideElement sidebarButton = $(By.cssSelector(pathCss + "header-component > div > div.btn-menu"));

    private SelenideElement sidebarRulesButton = $(By.cssSelector(pathCss + "menu-component > div > div.menu__btn-block > div:nth-child(2) > p"));

    private SelenideElement addRuleButton = $(By.cssSelector(pathCss + "regulation-component > div > div.regulation__title-block > div.add.alma-icon-plus"));

    private SelenideElement closeRuleWindowButton = $(By.cssSelector(pathCss + "regulation-component > div > div.regulation__title-block > div.close.alma-icon-close"));

    private SelenideElement nameRule = $(By.cssSelector(pathCss + "regulation-component > regulation-create-component > div > div.slimscroll-wrapper > div.info-container > input"));

    private SelenideElement childrenSelect = $(By.cssSelector(pathCss + "regulation-component > regulation-create-component > div > div.slimscroll-wrapper > div.info-container > div.devices-box > div.device > div.icon > img"));

    private SelenideElement eventsWindowButton = $(By.cssSelector(pathCss + "regulation-component > regulation-create-component > div > div.slimscroll-wrapper > div.info-container > div:nth-child(3) > p > span:nth-child(1)"));

    private SelenideElement eventFirstListButton = $(By.cssSelector(pathCss + "regulation-component > regulation-create-component > regulation-create-action > div > div.slimscroll-wrapper > div.info-container > div:nth-child(1) > div > p"));

    private SelenideElement eventSelectButton = $(By.cssSelector(pathCss + "regulation-component > regulation-create-component > regulation-create-action > div > div.slimscroll-wrapper > div.info-container > div:nth-child(1) > div.children-block > div > p"));

    private SelenideElement okEventButton = $(By.cssSelector(pathCss + "regulation-component > regulation-create-component > regulation-create-action > div > div.regulation-action__btn-block > button:nth-child(2)"));

    private SelenideElement actionsWindowButton = $(By.cssSelector(pathCss + "regulation-component > regulation-create-component > div > div.slimscroll-wrapper > div.info-container > div:nth-child(4) > p > span:nth-child(1)"));

    private SelenideElement actionFirstListButton = $(By.cssSelector(pathCss + "regulation-component > regulation-create-component > regulation-create-result > div > div.slimscroll-wrapper > div.info-container > div:nth-child(1) > div > p"));

    private SelenideElement actionSelectButton = $(By.cssSelector(pathCss + "regulation-component > regulation-create-component > regulation-create-result > div > div.slimscroll-wrapper > div.info-container > div:nth-child(1) > div.children-block > div:nth-child(1) > p"));

    private SelenideElement okActionButton = $(By.cssSelector(pathCss + "regulation-component > regulation-create-component > regulation-create-result > div > div.regulation-result__btn-block > button:nth-child(2)"));

    private SelenideElement okRuleButton = $(By.cssSelector(pathCss + "regulation-component > regulation-create-component > div > div.regulation-create__btn-block > button:nth-child(2)"));

    private ElementsCollection rulesList = $$(By.xpath(pathXpath + "regulation-component/div/div[2]/div[1]/div"));

    private SelenideElement confirmDeleteRuleButton = $(By.cssSelector(pathCss + "regulation-component > regulation-delete > div > div > button:nth-child(2)"));

    private SelenideElement confirmAddRuleButton = $(By.cssSelector(pathCss + "regulation-component > regulation-success > div > div.regulation-success__btn-block > button"));

    public RulesClass addRule(String name) throws InterruptedException {
        MapPage mapPage = new MapPage(new MapPageWeb());
        if(mapPage.getProfilesList().size() == 0){
            AddProfileWeb addProfile = new AddProfileWeb();
            addProfile.addProfile(mapPage);
        }

        if(!sidebarRulesButton.has(Condition.visible)) {
            sidebarButton.click();
        }
        sidebarRulesButton.shouldBe(Condition.visible);
        sidebarRulesButton.click();
        addRuleButton.shouldBe(Condition.visible);
        addRuleButton.click();
        childrenSelect.shouldBe(Condition.visible);
        nameRule.setValue(name);
        childrenSelect.click();

        eventsWindowButton.click();
        eventFirstListButton.shouldBe(Condition.visible);
        eventFirstListButton.click();
        eventSelectButton.shouldBe(Condition.visible);
        eventSelectButton.click();
        okEventButton.click();

        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", actionsWindowButton);
        actionsWindowButton.shouldBe(Condition.visible);
        actionsWindowButton.click();
        actionFirstListButton.shouldBe(Condition.visible);
        actionFirstListButton.click();
        actionSelectButton.shouldBe(Condition.visible);
        actionSelectButton.click();
        okActionButton.click();

        okRuleButton.shouldBe(Condition.visible);
        okRuleButton.click();

        confirmAddRuleButton.shouldBe(Condition.visible);
        confirmAddRuleButton.click();

        closeRuleWindowButton.shouldBe(Condition.visible);
        closeRuleWindowButton.click();
        return new RulesClass();
    }

    public ElementsCollection getRulesList() throws InterruptedException {
        if(!sidebarRulesButton.has(Condition.visible)) {
            sidebarButton.click();
        }
        sidebarRulesButton.click();
        closeRuleWindowButton.shouldBe(Condition.visible);
        Thread.sleep(2000);
        ElementsCollection list = rulesList;
        return list;
    }

    public void closeRulesWindow(){
        closeRuleWindowButton.click();
    }

    public RulesClass deleteRule(){
        if(!sidebarRulesButton.has(Condition.visible)) {
            sidebarButton.click();
        }
        sidebarRulesButton.click();
        addRuleButton.shouldBe(Condition.visible);
        System.out.println("List " + rulesList.size());

        int flag = 0;
        for(int i=0; i<rulesList.size(); i++){
            if(flag == 0) {
                try {
                    rulesList.get(i).findElementByXPath("div[3]").click();
                    flag = 1;
                } catch (ElementNotFound e) {
                    System.out.println("CONTINUE " + e.getMessage());
                    continue;
                }
            }
        }



        confirmDeleteRuleButton.shouldBe(Condition.visible);
        confirmDeleteRuleButton.click();
        confirmAddRuleButton.shouldBe(Condition.visible);
        confirmAddRuleButton.click();
        closeRuleWindowButton.click();
        return new RulesClass();
    }
}
