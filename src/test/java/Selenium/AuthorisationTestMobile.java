package Selenium;


import Selenium.BaseTest.BaseTestMobile;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.dubtsov.safe.PageObject.Map.MapPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by user on 28.12.17.
 */
public class AuthorisationTestMobile extends BaseTestMobile{

    @Test
    public void positiveAuthorisationTest() throws InterruptedException {
        MapPage mapPage = authorisationPage.authorisationUser(login, password);
        Assert.assertTrue(mapPage.getSidebarButton().shouldBe(Condition.visible).exists());
    }

}
