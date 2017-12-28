package Selenium;

import Selenium.BaseTest.BaseTestWeb;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.dubtsov.safe.PageObject.MapPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 25.10.17.
 */
public class AuthorisationTest extends BaseTestWeb {

    @Test
    public void positiveAuthorisationTest(){
        authorisationPage.authorisationUser(login, password);
        Selenide.getElement(By.id("map")).shouldBe(Condition.visible);
        Assert.assertTrue(Selenide.getElement(By.id("map")).exists());
    }

    @Test
    public void negativeAuthorisationTest(){
        authorisationPage.authorisationUser("fakeEmail", "FakePassword");
        Selenide.getElement(By.className("error")).shouldBe(Condition.visible);
        Assert.assertTrue(authorisationPage.getSubmitButton().exists() && Selenide.getElement(By.className("error")).exists());
    }

    @Test
    public void deleteAccount(){
        authorisationPage.authorisationUser(login, password);
        MapPage mapPage = new MapPage();
        authorisationPage = mapPage.deleteAccount("qqqqqq");
        authorisationPage.authorisationUser(login, password);
        Selenide.getElement(By.className("error")).shouldBe(Condition.visible);
        Assert.assertTrue(authorisationPage.getSubmitButton().exists() && Selenide.getElement(By.className("error")).exists());
    }

}
