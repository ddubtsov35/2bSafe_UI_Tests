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
public class TestBleat extends BaseTestWeb{

    @org.junit.Test
    public void test() throws Exception {
        open(link);

        AuthorisationPageWeb authorisationPageWeb = new AuthorisationPageWeb();
        authorisationPageWeb.authorisationUser("tester.2bsafe+100@gmail.com", "qqqqqq");
        Assert.assertTrue(true);

        //Удаление аккаунта для освобождения телефонного номера
        //Не работает из-за того что dev и надо делать сертификат на беке
        /*AuthorisationUser authorisationUser = new AuthorisationUser();
        authorisationUser.authorisationUser(GenerateEmail.emailStatic);

        DeleteAccountClass deleteAccountClass = new DeleteAccountClass();
        deleteAccountClass.deleteUser();*/

        //Удаление аккаунта для освобождения телефонного номера
        MapPage mapPage = new MapPage(new MapPageWeb());
        mapPage.deleteAccount("qqqqqq");
    }


}
