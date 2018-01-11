package com.dubtsov.safe.PageObject.Profile.Mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Map.Mobile.MapPageMobile;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 28.12.17.
 */
public class DeleteProfileMobile {

    private MapPage mapPage;

    private SelenideElement passwordField = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[5]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText"));

    private SelenideElement okButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[6]/android.widget.Button[2]"));

    public MapPage deleteProfile() throws InterruptedException {
        mapPage = new MapPage(new MapPageMobile());
        mapPage.getProfilesList().first().findElementByXPath("div[2]").click();
        mapPage.getContextMenuCommandsList().find(Condition.matchesText("Удалить устройство")).click();
        passwordField.sendKeys("qqqqqq");
        okButton.click();
        return new MapPage(new MapPageMobile());
    }

}
