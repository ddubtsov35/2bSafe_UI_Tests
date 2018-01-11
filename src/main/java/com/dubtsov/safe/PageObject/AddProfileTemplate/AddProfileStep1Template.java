package com.dubtsov.safe.PageObject.AddProfileTemplate;

import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Map.Mobile.MapPageMobile;
import com.dubtsov.safe.PageObject.Map.Web.MapPageWeb;
import com.dubtsov.safe.PageObject.Profile.Web.AddProfileWebStep2;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep5_2Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 21.12.17.
 */
public class AddProfileStep1Template {

    protected String path;

    protected SelenideElement name = $(By.name("name"));

    protected SelenideElement age = $(By.name("age"));

    protected SelenideElement photo = $(By.id("activate-device-file"));

    protected SelenideElement phone = $(By.name("number"));

    protected SelenideElement sendSms = $(By.name("send_sms"));

    protected SelenideElement successButton;

    protected SelenideElement skipButton;


    public MapPage skipStepClick(MapPageWeb mapPageWeb){
        skipButton.click();
        return new MapPage(mapPageWeb);
    }

    public MapPage skipStepClick(MapPageMobile mapPageMobile){
        skipButton.click();
        return new MapPage(mapPageMobile);
    }


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
