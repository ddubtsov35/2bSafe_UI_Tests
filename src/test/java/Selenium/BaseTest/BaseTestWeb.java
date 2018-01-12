package Selenium.BaseTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.dubtsov.safe.GenerateTestData.GenerateEmail;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep1Template;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep2Template;
import com.dubtsov.safe.PageObject.Authorisation.Web.AuthorisationPageWeb;
import com.dubtsov.safe.PageObject.LinkActivationAccount.LinkActivationAccount;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep1Page;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep3Page;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep4Page;
import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 21.12.17.
 */
public class BaseTestWeb {

    protected static AuthorisationPageWeb authorisationPage;
    protected static RegistrationStep1Page registrationStep1Page;
    protected static LinkActivationAccount linkActivationAccount;
    protected static RegistrationStep3Page registrationStep3Page;
    protected static RegistrationStep4Page registrationStep4Page;
    protected static AddProfileStep1Template registrationStep5Page;
    protected static AddProfileStep2Template registrationStep5_2Page;
    protected static String login;
    protected static String password;
    protected static String link;

    @BeforeClass
    public static void beforeClass() throws IOException {

        GenerateEmail.getGeneratedEmail();

        authorisationPage = new AuthorisationPageWeb();
        registrationStep1Page = new RegistrationStep1Page();
        linkActivationAccount = new LinkActivationAccount();
        registrationStep3Page = new RegistrationStep3Page();

        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = false;

        Configuration.startMaximized = false;

        System.setProperty("webdriver.chrome.driver", "/home/user/IdeaProjects/_2bSafe_UI_Test/chromedriver");
        Configuration.browser = "chrome";

        login = "tester.2bsafe@gmail.com";
        password = "qqqqqq";
        link = "https://lkdev.safec.ru";
    }

    @After
    public void after(){
        Selenide.close();
    }
}
