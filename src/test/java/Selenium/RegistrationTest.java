package Selenium;

import com.codeborne.selenide.*;
import com.dubtsov.safe.PageObject.LinkActivationAccount.LinkActivationAccount;
import com.dubtsov.safe.PageObject.Registration.*;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


/**
 * Created by user on 27.10.17.
 */
public class RegistrationTest extends BaseTest{

    @Test
    public void registrationTest_WithoutPhone_WithProfile() throws Exception {
        authorisationPage.openRegistrationUserPage();
        registrationStep1Page.registration();
        linkActivationAccount.registrationLinkClick();
        registrationStep4Page = registrationStep3Page.successButtonClick();
        registrationStep5Page = registrationStep4Page.skipStepClick();
        registrationStep5_2Page = registrationStep5Page.addProfileStep1("TestName", 18, "9181111111");
        registrationStep5_2Page.selectSchoolConfirm();

        SelenideElement result = $(By.cssSelector("body > app-root > content-component > map-component")).shouldBe(exist);
        Assert.assertTrue(result != null);
    }

    @Test
    public void registrationTest_WithPhone_WithProfile() throws Exception {
        authorisationPage.openRegistrationUserPage();
        registrationStep1Page.registration();
        linkActivationAccount.registrationLinkClick();
        registrationStep4Page = registrationStep3Page.successButtonClick();
        registrationStep5Page = registrationStep4Page.addPhone();
        registrationStep5_2Page = registrationStep5Page.addProfileStep1("TestName2", 11, "9182222222");
        registrationStep5_2Page.selectSchoolConfirm();

        SelenideElement result = $(By.cssSelector("body > app-root > content-component > map-component")).shouldBe(exist);
        Assert.assertTrue(result != null);

        //Удаление аккаунта для освобождения телефонного номера
        /*AuthorisationUser authorisationUser = new AuthorisationUser();
        authorisationUser.authorisationUser();

        DeleteAccountClass deleteAccountClass = new DeleteAccountClass();
        deleteAccountClass.deleteUser();*/
    }

    @Test
    public void registrationTest_WithoutPhone_WithoutProfile() throws Exception {
        authorisationPage.openRegistrationUserPage();
        registrationStep1Page.registration();
        linkActivationAccount.registrationLinkClick();
        registrationStep4Page = registrationStep3Page.successButtonClick();
        registrationStep5Page = registrationStep4Page.skipStepClick();
        registrationStep5Page.skipStepClick();

        SelenideElement result = $(By.cssSelector("body > app-root > content-component > map-component")).shouldBe(exist);
        Assert.assertTrue(result != null);
    }

    @Test
    public void registrationTest_WithPhone_WithoutProfile() throws Exception {
        authorisationPage.openRegistrationUserPage();
        registrationStep1Page.registration();
        linkActivationAccount.registrationLinkClick();
        registrationStep4Page = registrationStep3Page.successButtonClick();
        registrationStep5Page = registrationStep4Page.addPhone();
        registrationStep5Page.skipStepClick();

        SelenideElement result = $(By.cssSelector("body > app-root > content-component > map-component")).shouldBe(exist);
        Assert.assertTrue(result != null);

        //Удаление аккаунта для освобождения телефонного номера
        /*AuthorisationUser authorisationUser = new AuthorisationUser();
        authorisationUser.authorisationUser();

        DeleteAccountClass deleteAccountClass = new DeleteAccountClass();
        deleteAccountClass.deleteUser();*/
    }


}
