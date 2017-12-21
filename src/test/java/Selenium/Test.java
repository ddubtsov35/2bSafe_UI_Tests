package Selenium;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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

        //$(By.name("phone")).clear();
        //$(By.name("phone")).click();
        System.out.println($(By.name("phone")).getValue());
        while(!$(By.name("phone")).getValue().equals("")) {
            $(By.name("phone")).sendKeys(Keys.BACK_SPACE);
        }
        $(By.name("phone")).setValue("(951) 111-1111");


    }
}
