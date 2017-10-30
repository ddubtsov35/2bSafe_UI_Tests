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

    String path = "/html/body/app-root/activate-component/activate-component-phone/div[1]";

    private SelenideElement phone = $(By.name("phone"));

    private SelenideElement nextButton = $(By.xpath(path + "/button"));

    private SelenideElement skipStep = $(By.xpath(path + "/p[2]"));

    private SelenideElement inputCode = $(By.name("code"));

    private SelenideElement cancelButton = $(By.linkText("отмена"));

    private SelenideElement okButton = $(By.linkText("ок"));

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
        inputCode.setValue(OnlineSimPage.getCode());
        okButton.click();
    }


}
