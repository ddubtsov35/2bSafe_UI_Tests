package com.dubtsov.safe.PageObject.Registration.Mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.Authorisation.Web.AuthorisationPageWeb;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep4Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 28.12.17.
 */
public class RegistrationMobileStep3 {

    private SelenideElement button = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));

    private SelenideElement message = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View"));

    public RegistrationMobileStep4 successButtonClick() throws InterruptedException {
        message.shouldHave(Condition.text("Регистрация завершена"));
        button.click();
        return new RegistrationMobileStep4();
    }

    public AuthorisationPageWeb failButtonClick(){
        message.shouldHave(Condition.text("Истекло время подтверждения аккаунта"));
        button.click();
        return new AuthorisationPageWeb();
    }

}
