package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.SwitchHandles.SwitchHandles;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 27.10.17.
 */
public class RegistrationStep4Page {

    String path = "/html/body/app-root/activate-component/activate-component-phone";

    private SelenideElement phone = $(By.name("phone"));

    private SelenideElement nextButton = $(By.xpath(path + "/div[1]/button"));

    private SelenideElement skipStep = $(By.xpath(path + "/div[1]/p[2]"));

    private SelenideElement inputCode = $(By.name("code"));

    private SelenideElement cancelButton = $(By.xpath(path + "/div[3]/div/div/button[2]"));

    private SelenideElement okButton = $(By.xpath(path + "/div[3]/div/div/button[1]"));

    public RegistrationStep5Page skipStepClick(){
        skipStep.click();
        return new RegistrationStep5Page();
    }

    public void addPhone() throws InterruptedException {
        String phoneStr = OnlineSimPage.getPhoneNumber();
        SwitchHandles.switchHandle();
        phone.setValue(phoneStr);
        nextButton.click();
        //Окно ввода кода
        $(By.xpath("/html/body/app-root/activate-component/activate-component-phone/div[3]/div")).shouldBe(Condition.visible);
        SwitchHandles.switchHandle();
        String code = OnlineSimPage.getCode();
        SwitchHandles.switchHandle();
        inputCode.setValue(code);
        okButton.click();
    }


}
