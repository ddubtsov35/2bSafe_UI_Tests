package Selenium.BaseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user on 28.12.17.
 */
public class BaseTestMobile {

    AndroidDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/user/Загрузки/test.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");

        URL url = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver(url, desiredCapabilities);
    }
}
