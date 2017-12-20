package Selenium;

import com.codeborne.selenide.Configuration;
import com.dubtsov.safe.PageObject.MapPage;
import com.dubtsov.safe.PageObject.SmsRuPage;
import com.codeborne.selenide.Selenide;
import com.dubtsov.safe.Response.ResponseClass;
import com.google.common.reflect.ClassPath;
import org.junit.Assert;
import org.openqa.selenium.By;
import sun.dc.pr.PathFiller;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 20.11.17.
 */
public class Test {
    @org.junit.Test
    public void test(){
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        open("https://lkdev.safec.ru/activate/phone");
        $(By.name("phone")).setValue("(951) 651-2600");

        /*$(By.name("phone")).clear();
        $(By.name("phone")).click();
        $(By.name("phone")).setValue("(951) 111-1111");*/

        Assert.assertTrue(false);
        System.out.println("111");

    }
}
