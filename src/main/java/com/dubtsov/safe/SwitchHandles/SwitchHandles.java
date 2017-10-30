package com.dubtsov.safe.SwitchHandles;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 30.10.17.
 */
public class SwitchHandles {

    public static void switchHandle(){
        WebDriver driver = WebDriverRunner.getWebDriver();

        List<String> handlesList = new ArrayList<String>();
        String currentHanle = driver.getWindowHandle();
        String nextHandle = null;
        for(int i = 0 ; i < driver.getWindowHandles().size() ; i ++){
            try {
                handlesList.add(driver.getWindowHandles().toArray()[i].toString());
                if(!handlesList.get(i).equals(currentHanle)){
                    nextHandle = handlesList.get(i);
                }
            } catch (NullPointerException ex) {
                System.out.println("FAIL!");
            }
        }
        System.out.println("HendlesList " + handlesList.toString());
        System.out.println("CurrentHandle " + currentHanle);
        System.out.println("NextHandle " + nextHandle);
        driver.switchTo().window(nextHandle);
    }

}
