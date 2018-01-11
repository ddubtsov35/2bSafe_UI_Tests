package Selenium.BaseTest;

import com.codeborne.selenide.WebDriverRunner;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep1Template;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep2Template;
import com.dubtsov.safe.PageObject.Authorisation.Mobile.AuthorisationPageMobile;
import com.dubtsov.safe.PageObject.LinkActivationAccount.LinkActivationAccount;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep1Page;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep3Page;
import com.dubtsov.safe.PageObject.Registration.Web.RegistrationStep4Page;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user on 28.12.17.
 */
public class BaseTestMobile {

    static AppiumDriver driver;

    protected static AuthorisationPageMobile authorisationPage;
    protected static RegistrationStep1Page registrationStep1Page;
    protected static LinkActivationAccount linkActivationAccount;
    protected static RegistrationStep3Page registrationStep3Page;
    protected static String login;
    protected static String password;

    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        authorisationPage = new AuthorisationPageMobile();
        registrationStep1Page = new RegistrationStep1Page();
        linkActivationAccount = new LinkActivationAccount();
        registrationStep3Page = new RegistrationStep3Page();

        login = "ui_test218@p33.org";
        password = "qqqqqq";

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/user/Загрузки/test.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver(url, desiredCapabilities);

        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void after(){
        driver.quit();
    }
}
