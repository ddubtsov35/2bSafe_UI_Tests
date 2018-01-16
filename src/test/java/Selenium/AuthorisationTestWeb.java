package Selenium;

import Selenium.BaseTest.BaseTestWeb;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Map.Web.MapPageWeb;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 25.10.17.
 */
public class AuthorisationTestWeb extends BaseTestWeb {

    @Before
    public void before(){
        open(link);
    }

    @Test
    @DisplayName("Авторизация")
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

    @Ignore
    @Test
    public void deleteAccount(){
        authorisationPage.authorisationUser(login, password);
        MapPage mapPage = new MapPage(new MapPageWeb());
        authorisationPage = mapPage.deleteAccount("qqqqqq");
        authorisationPage.authorisationUser(login, password);
        Selenide.getElement(By.className("error")).shouldBe(Condition.visible);
        Assert.assertTrue(authorisationPage.getSubmitButton().exists() && Selenide.getElement(By.className("error")).exists());
    }

}
