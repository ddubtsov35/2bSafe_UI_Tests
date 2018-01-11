package com.dubtsov.safe.PageObject.Map.Web;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by user on 09.01.18.
 */
public class MapPageWeb{

    public String path = "body > app-root > content-component > ";

    public SelenideElement sidebarButton = $(By.cssSelector("header-component > div > div.btn-menu"));

    public SelenideElement updateInfo = $(By.cssSelector("header-component > div > div.shape.alma-icon-update"));

    public SelenideElement sidebarEmail = $(By.cssSelector("menu-component > div > div.menu__email-block.theme-text-color-light-bg > p"));

    public SelenideElement sidebarZoneButton = $(By.cssSelector("menu-component > div > div.menu__btn-block > div:nth-child(1) > p"));

    public SelenideElement sidebarRuleButton = $(By.cssSelector("menu-component > div > div.menu__btn-block > div:nth-child(2) > p"));

    public SelenideElement sidebarAddProfileButton = $(By.cssSelector("menu-component > div > div.menu__devices-block > div > p"));

    public SelenideElement logout = $(By.cssSelector("menu-component > div > div.menu__other-btn > div:nth-child(5) > p"));

    public ElementsCollection profilesList = $$(By.xpath("/html/body/app-root/content-component/menu-component/div/div[4]/section"));

    public ElementsCollection contextMenuCommandsList = $$(By.xpath("/html/body/app-root/content-component/menu-component/div[3]/div"));

    public SelenideElement contextMenuCommandsHead = $(By.cssSelector(path + "menu-component > div > div.menu__email-block.theme-text-color-light-bg > div"));

    public SelenideElement deleteAccountButton = $(By.cssSelector(path + "menu-component > div.menu__setting-modal-window > div:nth-child(3) > p"));

    public SelenideElement deleteAccountInputPassword = $(By.cssSelector(path + "settings-component > setting-remove-component > div > form > input"));

    public SelenideElement deleteAccountOkButton = $(By.cssSelector(path + "settings-component > setting-remove-component > div > div > button:nth-child(2)"));

}
