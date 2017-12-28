package Selenium.BaseTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep1Template;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep2Template;
import com.dubtsov.safe.PageObject.Authorisation.AuthorisationPage;
import com.dubtsov.safe.PageObject.LinkActivationAccount.LinkActivationAccount;
import com.dubtsov.safe.PageObject.Profile.AddProfileStep1;
import com.dubtsov.safe.PageObject.Profile.AddProfileStep2;
import com.dubtsov.safe.PageObject.Registration.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 21.12.17.
 */
public class BaseTestWeb {

    protected static AuthorisationPage authorisationPage;
    protected static RegistrationStep1Page registrationStep1Page;
    protected static LinkActivationAccount linkActivationAccount;
    protected static RegistrationStep3Page registrationStep3Page;
    protected static RegistrationStep4Page registrationStep4Page;
    protected static AddProfileStep1Template registrationStep5Page;
    protected static AddProfileStep2Template registrationStep5_2Page;
    protected static String login;
    protected static String password;

    @BeforeClass
    public static void beforeClass(){
        authorisationPage = new AuthorisationPage();
        registrationStep1Page = new RegistrationStep1Page();
        linkActivationAccount = new LinkActivationAccount();
        registrationStep3Page = new RegistrationStep3Page();

        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;

        System.setProperty("webdriver.chrome.driver", "/home/user/IdeaProjects/_2bSafe_UI_Test/chromedriver");
        Configuration.browser = "chrome";

        login = "ui_test218@p33.org";
        password = "qqqqqq";
    }

    @After
    public void after(){
        Selenide.close();
    }
}
