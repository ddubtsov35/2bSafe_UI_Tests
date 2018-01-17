package com.dubtsov.safe.PageObject.SmsRu;

import com.codeborne.selenide.*;
import com.dubtsov.safe.SwitchHandles.SwitchHandles;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.Keys.CONTROL;

/**
 * Created by user on 27.10.17.
 */
public class SmsRuPage {

    private static ElementsCollection phoneList = $$(By.xpath("//*[@id=\"refreshPhoneList\"]/div[1]/div[2]/ul/li/a/span/strong"));
    private static ElementsCollection smsList = $$(By.xpath("//*[@id=\"refreshMessageList\"]/div[2]/ul/li"));
    private static SelenideElement phoneRefresh = $(By.xpath("//*[@id=\"refreshPhoneList\"]/div[1]/div[1]/div/div/ul/li/a/i"));
    private static SelenideElement smsRefresh = $(By.xpath("//*[@id=\"refreshMessageList\"]/div[1]/div/div/ul/li[2]/a/i"));

    public static String phoneNumber;
    public static String code;
    public static String codeInput = "";
    private static int iterator = 0;
    private static int iteratorUpdate = 180;//Примерно 3 минуты

    private static String regexpCode(String text){
        Pattern pattern = Pattern.compile("[0-9]{4}");
        Matcher matcher;
        matcher = pattern.matcher(text);
        String code = null;

        while(matcher.find()){
            code = matcher.group();
        }
        System.out.println("Code: " + code);
        return code;
    }

    public static String getCode() throws InterruptedException {
       open("https://onlinesim.ru/sms-receive");
       ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", getWebDriver().findElement(By.xpath("//*[@id=\"index\"]/div[6]/div/h1")));
       phoneList.get(iterator - 1).click();
       int flag = 0;
       while (flag == 0){
           for(int i=0; i<smsList.size(); i++){
               System.out.println(smsList.get(i).getText());
               if(smsList.get(i).getText().contains("ALMATEL") && !smsList.get(i).getText().equals(codeInput)){
                   System.out.println("Good! " + smsList.get(i).getText());
                   flag = 1;
                   code = regexpCode(smsList.get(i).getText());
                   break;
               } else {
                   if(iteratorUpdate > 0) {
                       smsRefresh.click();
                       iteratorUpdate -= 1;
                   } else{
                       return null;
                   }
               }
           }
       }
       codeInput = code;
       return code;
    }

    public static String getPhoneNumber(){
        Selenide.executeJavaScript("window.open('','_blank');");
        Selenide.switchTo().window(1);
        open("https://onlinesim.ru/sms-receive");
        phoneRefresh.click();
        phoneList.shouldHave(sizeGreaterThan(0));
        System.out.println(phoneList);
        if(iterator < phoneList.size()) {
            for (int i = iterator; i < phoneList.size(); i++) {
                phoneNumber = phoneList.get(i).getText().toString().substring(2);
                iterator = i + 1;
                System.out.println("PhoneNumber " + phoneList.get(i).getText());
                break;
            }
        } else{
            return null;
        }
        return phoneNumber;
    }

}
