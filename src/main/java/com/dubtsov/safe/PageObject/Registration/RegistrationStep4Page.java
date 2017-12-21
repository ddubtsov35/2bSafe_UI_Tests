package com.dubtsov.safe.PageObject.Registration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.SmsRu.SmsRuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 27.10.17.
 */
public class RegistrationStep4Page {

    String path = "body > app-root > main-activate-component > activate-component-phone > ";

    private SelenideElement phone = $(By.name("phone"));

    private SelenideElement nextButton = $(By.cssSelector(path + "div.activate-phone > button"));

    private SelenideElement skipStep = $(By.cssSelector(path + "div.activate-phone > p.next-step.theme-text-color-light"));

    private SelenideElement inputCode = $(By.name("code"));

    private SelenideElement cancelButton = $(By.cssSelector(path + "div.activate-phone-modal > div > div > button:nth-child(1)"));

    private SelenideElement okButton = $(By.cssSelector(path + "div.activate-phone-modal > div > div > button:nth-child(2)"));

    private SelenideElement inputCodeWindow = $(By.cssSelector("div.activate-phone-modal > div"));

    private SelenideElement errorMessage = $(By.cssSelector("div.activate-phone > p.error"));

    public RegistrationStep5Page skipStepClick(){
        skipStep.click();
        return new RegistrationStep5Page();
    }

    public RegistrationStep5Page addPhone() throws InterruptedException {
        do {
            String phoneStr = SmsRuPage.getPhoneNumber();
            if(phoneStr.equals("null")){return null;}
            Selenide.switchTo().window(0);
            while(!phone.getValue().equals("")) {
                phone.sendKeys(Keys.BACK_SPACE);
            }
            phone.setValue(phoneStr);
            nextButton.click();
            Thread.sleep(3000);
            System.out.println(errorMessage.has(Condition.visible));
        } while (inputCodeWindow.has(Condition.hidden));

        inputCodeWindow.shouldBe(Condition.visible);
        do {
            Selenide.switchTo().window(1);
            String code = SmsRuPage.getCode();
            Selenide.switchTo().window(0);
            inputCode.setValue(code);
            Thread.sleep(2000);
            okButton.click();
            Thread.sleep(2000);
        } while (inputCodeWindow.has(Condition.visible));

        return new RegistrationStep5Page();
    }


}
