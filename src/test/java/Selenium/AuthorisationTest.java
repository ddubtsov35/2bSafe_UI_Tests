package Selenium;

import com.dubtsov.safe.PageObject.AuthorisationPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 25.10.17.
 */
public class AuthorisationTest {

    @Test
    public void test(){
        open("http://google.com");
    }

}
