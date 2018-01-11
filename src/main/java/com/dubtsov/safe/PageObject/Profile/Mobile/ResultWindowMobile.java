package com.dubtsov.safe.PageObject.Profile.Mobile;

import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Map.Mobile.MapPageMobile;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 28.12.17.
 */
public class ResultWindowMobile {

    private SelenideElement okButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.app.Dialog[1]/android.view.View/android.widget.Button"));

    public MapPage confirm(){
        okButton.click();
        return new MapPage(new MapPageMobile());
    }

}
