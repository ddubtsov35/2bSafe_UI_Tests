package Selenium;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.dubtsov.safe.PageObject.AuthorisationPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 25.10.17.
 */
public class AuthorisationTest {

    AuthorisationPage authorisationPage;

    @Before
    public void before(){
        authorisationPage = new AuthorisationPage();
        open("https://lkdev.safec.ru/");
    }

    @Test
    public void positiveAuthorisationTest(){
        authorisationPage.authorisationUser("qqq12@p33.org", "qqqqqq");
        Assert.assertTrue(Selenide.getElement(By.id("map")).exists());
    }

    @Test
    public void negativeAuthorisationTest(){
        authorisationPage.authorisationUser("fakeEmail", "FakePassword");
        Assert.assertTrue(authorisationPage.getSubmitButton().exists() && Selenide.getElement(By.className("error")).exists());
    }

}
