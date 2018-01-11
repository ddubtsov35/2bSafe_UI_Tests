package com.dubtsov.safe.PageObject.Profile.Mobile;

import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep2Template;
import com.dubtsov.safe.PageObject.Profile.Web.AddProfileWebStep2;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep5_2Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 28.12.17.
 */
public class AddProfileMobileStep1 {

    protected String path;

    protected SelenideElement name = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText"));

    protected SelenideElement age = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText"));

    protected SelenideElement photo = $(By.id("activate-device-file"));

    protected SelenideElement phone = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText"));

    protected SelenideElement sendSms = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[5]/android.view.View[1]/android.view.View/android.view.View"));

    protected SelenideElement successButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.Button"));

    public AddProfileStep2Template addProfileStep1(String name, int age, String phone, String type){
        this.name.setValue(name);
        this.age.setValue(String.valueOf(age));
        this.phone.setValue(phone);
        this.photo.uploadFromClasspath("photo.jpg");
        successButton.click();
        if (type.equals("reg")) {
            return new RegistrationStep5_2Page();
        } else{
            return new AddProfileWebStep2();
        }
    }

}
