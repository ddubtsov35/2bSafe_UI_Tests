package Selenium;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.dubtsov.safe.PageObject.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 27.10.17.
 */
public class RegistrationTest {

    RegistrationStep1Page registrationStep1Page;
    RegistrationStep3Page registrationStep3Page;
    RegistrationStep4Page registrationStep4Page;
    TempMailPage tempMailPage;

    @Before
    public void before(){
        Configuration.timeout = 10000;

        registrationStep1Page = new RegistrationStep1Page();
        registrationStep3Page = new RegistrationStep3Page();

        tempMailPage = new TempMailPage();
        open("https://lkdev.safec.ru/reg");

    }

    @Test
    public void positiveRegistrationTest() throws IOException, InterruptedException {
        registrationStep1Page.registration();
        tempMailPage.registrationLinkClick();
        registrationStep4Page = registrationStep3Page.successButtonClick();
        registrationStep4Page.addPhone();
    }

    @Test
    public void qwe() throws InterruptedException {
        //OnlineSimPage.getPhoneNumber();
        //OnlineSimPage.getCode();
    }

    /*@After
    public void after(){
        Selenide.Wait().withTimeout(1000000, TimeUnit.MILLISECONDS);
    }*/

}
