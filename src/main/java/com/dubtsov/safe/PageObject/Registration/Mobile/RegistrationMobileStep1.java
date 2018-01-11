package com.dubtsov.safe.PageObject.Registration.Mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.GenerateTestData.GenerateEmail;
import com.dubtsov.safe.PageObject.Authorisation.Web.AuthorisationPageWeb;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep2Page;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 28.12.17.
 */
public class RegistrationMobileStep1 {

    private SelenideElement login = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText"));

    private SelenideElement password = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText"));

    private SelenideElement submitButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));

    private SelenideElement authorisationButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));

    public AuthorisationPageWeb openAuthorisationUserPage(){
        authorisationButton.click();
        return new AuthorisationPageWeb();
    }

    public RegistrationMobileStep2 registration() throws IOException {
        String email = GenerateEmail.getGeneratedEmail();
        login.setValue(email);
        password.setValue("qqqqqq");
        submitButton.click();
        return new RegistrationMobileStep2();
    }

}
