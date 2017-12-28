package Selenium;

import Selenium.BaseTest.BaseTestWeb;
import com.dubtsov.safe.PageObject.Zone.ZoneClass;
import org.junit.Assert;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 22.12.17.
 */
public class ZoneTest extends BaseTestWeb {

    int before;
    ZoneClass zoneClass;

    @Before
    public void before() throws Exception {
        open("https://lkdev.safec.ru");

        authorisationPage.authorisationUser(login, password);
        zoneClass = new ZoneClass();
        before = zoneClass.getZoneList().size();
        zoneClass.closeZonesWindow();
    }

    @org.junit.Test
    public void addZone() throws InterruptedException {
        System.out.println("Число зон ДО добавления: " + before);
        int after = zoneClass.addZone().getZoneList().size();
        zoneClass.closeZonesWindow();
        System.out.println("Число зон После добавления: " + after);
        Assert.assertTrue(after - before == 1);
    }

    @org.junit.Test
    public void deleteZone() throws InterruptedException {
        System.out.println("Число зон ДО удаления: " + before);
        if(before == 0){
            zoneClass.addZone();
        }
        int after = zoneClass.deleteZone().getZoneList().size();
        zoneClass.closeZonesWindow();
        System.out.println("Число зон После удаления: " + after);
        Assert.assertTrue(before - after == 1);
    }

}
