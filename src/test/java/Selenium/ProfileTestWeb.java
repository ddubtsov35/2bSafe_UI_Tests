package Selenium;

import Selenium.BaseTest.BaseTestWeb;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Profile.Web.AddProfileWeb;
import com.dubtsov.safe.PageObject.Profile.Web.DeleteProfileWeb;
import org.junit.Assert;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 21.12.17.
 */
public class ProfileTestWeb extends BaseTestWeb {

    MapPage mapPage;
    int profileListSizeBefore;

    @Before
    public void before(){
        open("https://lkdev.safec.ru");

        mapPage = authorisationPage.authorisationUser(login, password);
        profileListSizeBefore = mapPage.getProfilesListSize();
    }

    @org.junit.Test
    public void addProfile() throws InterruptedException {
        AddProfileWeb addProfile = new AddProfileWeb();
        mapPage = addProfile.addProfile(mapPage);
        int profileListSizeAfter = mapPage.getProfilesListSize();
        Assert.assertTrue(profileListSizeAfter - profileListSizeBefore == 1);
    }

    @org.junit.Test
    public void deleteProfile() throws InterruptedException {
        if(profileListSizeBefore == 0){
            AddProfileWeb addProfile = new AddProfileWeb();
            mapPage = addProfile.addProfile(mapPage);
            mapPage = addProfile.addProfile(mapPage);
            profileListSizeBefore = mapPage.getProfilesListSize();
        }

        DeleteProfileWeb deleteProfile = new DeleteProfileWeb();
        mapPage = deleteProfile.deleteProfile();

        int profileListSizeAfter = mapPage.getProfilesListSize();
        Assert.assertTrue(profileListSizeBefore - profileListSizeAfter == 1);
    }

}
