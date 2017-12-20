package Selenium;

import com.codeborne.selenide.Configuration;
import com.dubtsov.safe.PageObject.MapPage;
import com.dubtsov.safe.PageObject.SmsRuPage;
import com.codeborne.selenide.Selenide;
import com.dubtsov.safe.Response.ResponseClass;
import com.google.common.reflect.ClassPath;
import sun.dc.pr.PathFiller;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 20.11.17.
 */
public class Test {
    @org.junit.Test
    public void test(){
        /*Configuration.browser = "chrome";
        open("http://sms.ru");
        SmsRuPage smsRuPage = new SmsRuPage();*/
        //smsRuPage.loginButton.click();
        final File f = new File(MapPage.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        System.out.println(f);
    }
}
