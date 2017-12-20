package Selenium;

import com.codeborne.selenide.*;
import com.dubtsov.safe.ApiMethods.AuthorisationUser.AuthorisationUser;
import com.dubtsov.safe.ApiMethods.DeleteAccount.DeleteAccountClass;
import com.dubtsov.safe.PageObject.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


/**
 * Created by user on 27.10.17.
 */
public class RegistrationTest {

    RegistrationStep1Page registrationStep1Page;
    RegistrationStep3Page registrationStep3Page;
    RegistrationStep4Page registrationStep4Page;
    RegistrationStep5Page registrationStep5Page;
    RegistrationStep5_2Page registrationStep5_2Page;
    LinkActivationAccount linkActivationAccount;


    @Before
    public void before(){
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;

        System.setProperty("webdriver.chrome.driver", "/home/user/IdeaProjects/_2bSafe_UI_Test/chromedriver");
        Configuration.browser = "chrome";

        registrationStep1Page = new RegistrationStep1Page();
        registrationStep3Page = new RegistrationStep3Page();

        linkActivationAccount = new LinkActivationAccount();
        open("https://lkdev.safec.ru/reg");
    }

    @Test
    public void registrationTest_WithoutPhone_WithProfile() throws Exception {
        registrationStep1Page.registration();
        linkActivationAccount.registrationLinkClick();
        registrationStep4Page = registrationStep3Page.successButtonClick();
        registrationStep5Page = registrationStep4Page.skipStepClick();
        registrationStep5_2Page = registrationStep5Page.successButtonClick();
        registrationStep5_2Page.selectSchoolConfirm();

        SelenideElement result = $(By.cssSelector("body > app-root > content-component > map-component")).shouldBe(exist);
        Assert.assertTrue(result != null);
    }

    @Test
    public void registrationTest_WithPhone_WithProfile() throws Exception {
        registrationStep1Page.registration();
        linkActivationAccount.registrationLinkClick();
        registrationStep4Page = registrationStep3Page.successButtonClick();
        registrationStep5Page = registrationStep4Page.addPhone();
        registrationStep5_2Page = registrationStep5Page.successButtonClick();
        registrationStep5_2Page.selectSchoolConfirm();

        SelenideElement result = $(By.cssSelector("body > app-root > content-component > map-component")).shouldBe(exist);
        Assert.assertTrue(result != null);

        //Удаление аккаунта для освобождения телефонного номера
        /*AuthorisationUser authorisationUser = new AuthorisationUser();
        authorisationUser.authorisationUser();

        DeleteAccountClass deleteAccountClass = new DeleteAccountClass();
        deleteAccountClass.deleteUser();*/
    }


}
