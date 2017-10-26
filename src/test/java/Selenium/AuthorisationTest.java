package Selenium;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.dubtsov.safe.PageObject.AuthorisationPage;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 25.10.17.
 */
public class AuthorisationTest {

    @Test
    public void test(){
        //open("https://lkdev.safec.ru/", AuthorisationPage.class);
        /*AuthorisationPage authorisationPage = Selenide.open("https://lkdev.safec.ru/", AuthorisationPage.class);
        authorisationPage.authorisationUser("qwe", "qwe");*/

        open("https://lkdev.safec.ru/");
        AuthorisationPage authorisationPage = new AuthorisationPage();
        authorisationPage.authorisationUser("4321", "123");

        ElementsCollection qwe = $$(By.xpath("aer"));
        qwe.
    }

}
