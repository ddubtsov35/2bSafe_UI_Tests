package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep1Template;
import com.dubtsov.safe.PageObject.Authorisation.AuthorisationPage;
import com.dubtsov.safe.PageObject.Profile.AddProfileStep1;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by user on 19.12.17.
 */
public class MapPage {

    private String path = "body > app-root > content-component > ";

    private SelenideElement sidebarButton = $(By.cssSelector("header-component > div > div.btn-menu"));

    private SelenideElement updateInfo = $(By.cssSelector("header-component > div > div.shape.alma-icon-update"));

    private SelenideElement sidebarEmail = $(By.cssSelector("menu-component > div > div.menu__email-block.theme-text-color-light-bg > p"));

    private SelenideElement sidebarZoneButton = $(By.cssSelector("menu-component > div > div.menu__btn-block > div:nth-child(1) > p"));

    private SelenideElement sidebarRuleButton = $(By.cssSelector("menu-component > div > div.menu__btn-block > div:nth-child(2) > p"));

    private SelenideElement sidebarAddProfileButton = $(By.cssSelector("menu-component > div > div.menu__devices-block > div > p"));

    private SelenideElement logout = $(By.cssSelector("menu-component > div > div.menu__other-btn > div:nth-child(5) > p"));

    private ElementsCollection profilesList = $$(By.xpath("/html/body/app-root/content-component/menu-component/div/div[4]/section"));

    private ElementsCollection contextMenuCommandsList = $$(By.xpath("/html/body/app-root/content-component/menu-component/div[3]/div"));

    private SelenideElement contextMenuCommandsHead = $(By.cssSelector(path + "menu-component > div > div.menu__email-block.theme-text-color-light-bg > div"));

    private SelenideElement deleteAccountButton = $(By.cssSelector(path + "menu-component > div.menu__setting-modal-window > div:nth-child(3) > p"));

    private SelenideElement deleteAccountInputPassword = $(By.cssSelector(path + "settings-component > setting-remove-component > div > form > input"));

    private SelenideElement deleteAccountOkButton = $(By.cssSelector(path + "settings-component > setting-remove-component > div > div > button:nth-child(2)"));

    public AddProfileStep1Template addProfileClickButton(){
        if(!sidebarEmail.has(Condition.visible)) {
            sidebarButton.click();
        }
        sidebarAddProfileButton.click();
        return new AddProfileStep1();
    }

    public ElementsCollection getProfilesList() throws InterruptedException {
        if(!sidebarEmail.has(Condition.visible)) {
            sidebarButton.click();
        }
        sidebarEmail.shouldBe(Condition.visible);
        Thread.sleep(1000);
        return profilesList;
    }

    public int getProfilesListSize(){
        ElementsCollection list;
        try {
             list = getProfilesList();
        } catch (Exception e){
            return 0;
        }
        System.out.println("Число профилей ребенка: " + list.size());
        return list.size();
    }

    public AuthorisationPage deleteAccount(String password){
        if(!sidebarEmail.has(Condition.visible)) {
            sidebarButton.click();
        }
        contextMenuCommandsHead.shouldBe(Condition.visible);
        contextMenuCommandsHead.click();
        deleteAccountButton.shouldBe(Condition.visible);
        deleteAccountButton.click();
        deleteAccountInputPassword.shouldBe(Condition.visible);
        deleteAccountInputPassword.setValue(password);
        deleteAccountOkButton.click();
        return new AuthorisationPage();
    }



    public SelenideElement getContextMenuCommandsHead(){
        return contextMenuCommandsHead;
    }

    public ElementsCollection getContextMenuCommandsList(){
        return contextMenuCommandsList;
    }
}
