package com.dubtsov.safe.PageObject.Registration.Mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Map.Mobile.MapPageMobile;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep5Page;
import com.dubtsov.safe.PageObject.SmsRu.SmsRuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by user on 28.12.17.
 */
public class RegistrationMobileStep4 {

    private SelenideElement phone = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText"));

    private SelenideElement nextButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));

    private SelenideElement skipStep = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button"));

    private SelenideElement inputCode = $(By.className("android.widget.EditText"));

    private SelenideElement okButton = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.Button[2]"));

    private SelenideElement inputCodeWindow = $(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View"));

    public RegistrationStep5Page skipStepClick(){
        skipStep.click();
        return new RegistrationStep5Page();
    }

    public MapPage addPhone() throws InterruptedException {
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
            System.out.println(inputCodeWindow.has(Condition.visible));
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

        return new MapPage(new MapPageMobile());
    }

}
