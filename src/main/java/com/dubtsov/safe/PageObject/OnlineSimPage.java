package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by user on 27.10.17.
 */
public class OnlineSimPage {

    private static ElementsCollection phoneList = $$(By.xpath("//*[@id=\"refreshPhoneList\"]/div[1]/div[2]/ul/li/a"));
    private static ElementsCollection smsList = $$(By.xpath("//*[@id=\"refreshMessageList\"]/div[2]/ul/li"));
    private static SelenideElement phoneRefresh = $(By.xpath("//*[@id=\"refreshPhoneList\"]/div[1]/div[1]/div/div/ul/li/a/i"));
    private static SelenideElement smsRefresh = $(By.xpath("//*[@id=\"refreshMessageList\"]/div[1]/div/div/ul/li[2]/a/i"));

    public static String phoneNumber;
    public static String code;

    public static String getCode() throws InterruptedException {
       Pattern pattern = Pattern.compile("[0-9]{4}");
       open("https://onlinesim.ru/sms-receive");
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", getWebDriver().findElement(By.xpath("//*[@id=\"index\"]/div[6]/div/h1")));

       phoneList.first().click();
       int flag = 0;
       while (flag == 0){
           for(int i=0; i<smsList.size(); i++){
               if(smsList.get(i).getText().contains("sms.Ru")){
                   System.out.println("Good! " + smsList.get(i).getText());
                   flag = 1;
                   code = smsList.get(i).getText();
                   break;
               } else {
                   smsRefresh.click();
               }
           }
       }

       return code;
    }

    public static String getPhoneNumber(){
        open("https://onlinesim.ru/sms-receive");
        System.out.println("PhoneNumber " + phoneList.first().getText());
        phoneNumber = phoneList.first().toString();
        return phoneList.first().toString();
    }

}
