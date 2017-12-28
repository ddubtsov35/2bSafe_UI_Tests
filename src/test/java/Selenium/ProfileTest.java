package Selenium;

import Selenium.BaseTest.BaseTestWeb;
import com.dubtsov.safe.PageObject.MapPage;
import com.dubtsov.safe.PageObject.Profile.*;
import org.junit.Assert;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 21.12.17.
 */
public class ProfileTest extends BaseTestWeb {

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
        AddProfile addProfile = new AddProfile();
        mapPage = addProfile.addProfile(mapPage);
        int profileListSizeAfter = mapPage.getProfilesListSize();
        Assert.assertTrue(profileListSizeAfter - profileListSizeBefore == 1);
    }

    @org.junit.Test
    public void deleteProfile() throws InterruptedException {
        if(profileListSizeBefore == 0){
            AddProfile addProfile = new AddProfile();
            mapPage = addProfile.addProfile(mapPage);
            mapPage = addProfile.addProfile(mapPage);
            profileListSizeBefore = mapPage.getProfilesListSize();
        }

        DeleteProfile deleteProfile = new DeleteProfile();
        mapPage = deleteProfile.deleteProfile();

        int profileListSizeAfter = mapPage.getProfilesListSize();
        Assert.assertTrue(profileListSizeBefore - profileListSizeAfter == 1);
    }

}
