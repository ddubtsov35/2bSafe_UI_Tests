package com.dubtsov.safe.PageObject.Map;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep1Template;
import com.dubtsov.safe.PageObject.Authorisation.Web.AuthorisationPageWeb;
import com.dubtsov.safe.PageObject.Map.Mobile.MapPageMobile;
import com.dubtsov.safe.PageObject.Map.Web.MapPageWeb;
import com.dubtsov.safe.PageObject.Profile.Web.AddProfileWebStep1;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by user on 19.12.17.
 */
public class MapPage {

    protected SelenideElement sidebarButton;

    protected SelenideElement updateInfo;

    protected SelenideElement sidebarEmail;

    protected SelenideElement sidebarZoneButton;

    protected SelenideElement sidebarRuleButton;

    protected SelenideElement sidebarAddProfileButton;

    protected SelenideElement logout;

    protected ElementsCollection profilesList;

    protected ElementsCollection contextMenuCommandsList;

    protected SelenideElement contextMenuCommandsHead;

    protected SelenideElement deleteAccountButton;

    protected SelenideElement deleteAccountInputPassword;

    protected SelenideElement deleteAccountOkButton;


    public MapPage(MapPageWeb mapPageWeb){
        this.sidebarButton = mapPageWeb.sidebarButton;
        this.updateInfo = mapPageWeb.updateInfo;
        this.sidebarEmail = mapPageWeb.sidebarEmail;
        this.sidebarZoneButton = mapPageWeb.sidebarZoneButton;
        this.sidebarRuleButton = mapPageWeb.sidebarRuleButton;
        this.sidebarAddProfileButton = mapPageWeb.sidebarAddProfileButton;
        this.logout = mapPageWeb.logout;
        this.profilesList = mapPageWeb.profilesList;
        this.contextMenuCommandsList = mapPageWeb.contextMenuCommandsList;
        this.contextMenuCommandsHead = mapPageWeb.contextMenuCommandsHead;
        this.deleteAccountButton = mapPageWeb.deleteAccountButton;
        this.deleteAccountButton = mapPageWeb.deleteAccountButton;
        this.deleteAccountInputPassword = mapPageWeb.deleteAccountInputPassword;
        this.deleteAccountOkButton = mapPageWeb.deleteAccountOkButton;
    }

    public MapPage(MapPageMobile mapPageMobile){
        this.sidebarButton = mapPageMobile.sidebarButton;
        this.updateInfo = mapPageMobile.updateInfo;
        this.sidebarEmail = mapPageMobile.sidebarEmail;
        this.sidebarZoneButton = mapPageMobile.sidebarZoneButton;
        this.sidebarRuleButton = mapPageMobile.sidebarRuleButton;
        this.sidebarAddProfileButton = mapPageMobile.sidebarAddProfileButton;
        this.logout = mapPageMobile.logout;
        this.profilesList = mapPageMobile.profilesList;
        this.contextMenuCommandsList = mapPageMobile.contextMenuCommandsList;
        this.contextMenuCommandsHead = mapPageMobile.contextMenuCommandsHead;
        this.deleteAccountButton = mapPageMobile.deleteAccountButton;
        this.deleteAccountButton = mapPageMobile.deleteAccountButton;
        this.deleteAccountInputPassword = mapPageMobile.deleteAccountInputPassword;
        this.deleteAccountOkButton = mapPageMobile.deleteAccountOkButton;
    }



    public AddProfileStep1Template addProfileClickButton(){
        if(!sidebarEmail.has(Condition.visible)) {
            sidebarButton.click();
        }
        sidebarAddProfileButton.click();
        return new AddProfileWebStep1();
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

    public AuthorisationPageWeb deleteAccount(String password){
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
        return new AuthorisationPageWeb();
    }



    public SelenideElement getContextMenuCommandsHead(){
        return contextMenuCommandsHead;
    }

    public ElementsCollection getContextMenuCommandsList(){
        return contextMenuCommandsList;
    }

    public SelenideElement getSidebarButton() {
        return sidebarButton;
    }
}
