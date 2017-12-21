package Selenium;

import com.codeborne.selenide.Selenide;
import com.dubtsov.safe.PageObject.Authorisation.AuthorisationPage;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 25.10.17.
 */
public class AuthorisationTest extends BaseTest{

    @Test
    public void positiveAuthorisationTest(){
        authorisationPage.authorisationUser("pp44@p33.org", "qqqqqq");
        Assert.assertTrue(Selenide.getElement(By.id("map")).exists());
    }

    @Test
    public void negativeAuthorisationTest(){
        authorisationPage.authorisationUser("fakeEmail", "FakePassword");
        Assert.assertTrue(authorisationPage.getSubmitButton().exists() && Selenide.getElement(By.className("error")).exists());
    }

}
