package com.dubtsov.safe.PageObject.Authorisation.Mobile;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Map.Mobile.MapPageMobile;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep1Page;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 28.12.17.
 */
public class AuthorisationPageMobile{

    protected SelenideElement login = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText"));

    protected SelenideElement password = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText"));

    protected SelenideElement submitButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));

    protected SelenideElement registrationButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));

    protected SelenideElement recoverPassword  = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button"));


    public MapPage authorisationUser(String email, String pwd){
        login.setValue(email);
        password.setValue(pwd);
        AppiumDriver appiumDriver = (AppiumDriver) WebDriverRunner.getWebDriver();
        appiumDriver.hideKeyboard();
        submitButton.click();
        return new MapPage(new MapPageMobile());
    }

    public RegistrationStep1Page openRegistrationUserPage(){
        registrationButton.click();
        return new RegistrationStep1Page();
    }


    public SelenideElement getLogin() {
        return login;
    }
    public SelenideElement getPassword() {
        return password;
    }
    public SelenideElement getRecoverPassword() {
        return recoverPassword;
    }
    public SelenideElement getSubmitButton() {
        return submitButton;
    }
    public SelenideElement getRegistrationButton() {
        return registrationButton;
    }

}
