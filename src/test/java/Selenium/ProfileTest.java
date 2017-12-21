package Selenium;

import com.dubtsov.safe.PageObject.MapPage;
import com.dubtsov.safe.PageObject.Profile.*;
import org.junit.Assert;

/**
 * Created by user on 21.12.17.
 */
public class ProfileTest extends BaseTest{



    @org.junit.Test
    public void addProfile() throws InterruptedException {
        MapPage mapPage = authorisationPage.authorisationUser("ui_test217@p33.org", "qqqqqq");
        int profileListSizeBefore = mapPage.getProfilesListSize();
        AddProfile addProfile = new AddProfile();
        mapPage = addProfile.addProfile(mapPage);
        int profileListSizeAfter = mapPage.getProfilesListSize();
        Assert.assertTrue(profileListSizeAfter - profileListSizeBefore == 1);
    }

    @org.junit.Test
    public void deleteProfile() throws InterruptedException {
        MapPage mapPage = authorisationPage.authorisationUser("ui_test217@p33.org", "qqqqqq");
        int profileListSizeBefore = mapPage.getProfilesListSize();
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
