package com.dubtsov.safe.PageObject.Registration.Mobile;

import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.Authorisation.Web.AuthorisationPageWeb;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 28.12.17.
 */
public class RegistrationMobileStep2 {

    private SelenideElement codeInput = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText"));

    private SelenideElement submitButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));

    public RegistrationMobileStep3 openAuthorisationUserPage(String code){
        codeInput.setValue(code);
        submitButton.click();
        return new RegistrationMobileStep3();
    }

}
