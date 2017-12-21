package Selenium;

import com.codeborne.selenide.Configuration;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep1Template;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep2Template;
import com.dubtsov.safe.PageObject.Authorisation.AuthorisationPage;
import com.dubtsov.safe.PageObject.LinkActivationAccount.LinkActivationAccount;
import com.dubtsov.safe.PageObject.Profile.AddProfileStep1;
import com.dubtsov.safe.PageObject.Profile.AddProfileStep2;
import com.dubtsov.safe.PageObject.Registration.*;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 21.12.17.
 */
public class BaseTest {

    AuthorisationPage authorisationPage;
    RegistrationStep1Page registrationStep1Page;
    LinkActivationAccount linkActivationAccount;
    RegistrationStep3Page registrationStep3Page;
    RegistrationStep4Page registrationStep4Page;
    AddProfileStep1Template registrationStep5Page;
    AddProfileStep2Template registrationStep5_2Page;

    @Before
    public void before(){
        authorisationPage = new AuthorisationPage();
        registrationStep1Page = new RegistrationStep1Page();
        linkActivationAccount = new LinkActivationAccount();
        registrationStep3Page = new RegistrationStep3Page();

        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;

        System.setProperty("webdriver.chrome.driver", "/home/user/IdeaProjects/_2bSafe_UI_Test/chromedriver");
        Configuration.browser = "chrome";

        open("https://lkdev.safec.ru");
    }
}
