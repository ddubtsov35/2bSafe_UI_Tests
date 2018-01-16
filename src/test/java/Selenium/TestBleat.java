package Selenium;

import Selenium.BaseTest.BaseTestWeb;
import com.dubtsov.safe.PageObject.Authorisation.Web.AuthorisationPageWeb;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Map.Web.MapPageWeb;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 12.01.18.
 */
public class TestBleat{

    @org.junit.Test
    public void test() throws Exception {

        try {
            Assert.assertTrue(false);
        } catch(Exception e){
            System.out.println("111");
        }



    }


}
