package com.dubtsov.safe.PageObject.Map.Mobile;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by user on 09.01.18.
 */
public class MapPageMobile {

    public SelenideElement sidebarMenuButton = $(By.xpath(""));

    public SelenideElement sidebarMenuDeleteAccountButton = $(By.xpath(""));

    public SelenideElement sidebarButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.Button"));

    public SelenideElement updateInfo = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.widget.Button"));

    public SelenideElement sidebarEmail = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[4]"));

    public SelenideElement sidebarZoneButton = $(By.xpath(""));

    public SelenideElement sidebarRuleButton = $(By.xpath(""));

    public SelenideElement sidebarAddProfileButton = $(By.xpath(""));

    public SelenideElement logout = $(By.xpath(""));

    public ElementsCollection profilesList = $$(By.xpath(""));

    public ElementsCollection contextMenuCommandsList = $$(By.xpath(""));

    public SelenideElement contextMenuCommandsHead = $(By.xpath(""));

    public SelenideElement deleteAccountButton = $(By.xpath(""));

    public SelenideElement deleteAccountInputPassword = $(By.xpath(""));

    public SelenideElement deleteAccountOkButton = $(By.xpath(""));


}
