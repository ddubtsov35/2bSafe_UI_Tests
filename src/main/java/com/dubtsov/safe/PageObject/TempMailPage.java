package com.dubtsov.safe.PageObject;

import com.codeborne.selenide.*;
import com.dubtsov.safe.GenerateTestData.GenerateEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.java2d.loops.FillRect;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 27.10.17.
 */
public class TempMailPage {

    private SelenideElement login = $(By.name("mail"));

    private SelenideElement safeButton = $(By.id("postbut"));

    private SelenideElement refreshButton = $(By.id("click-to-refresh"));

    private SelenideElement changeButton = $(By.id("click-to-change"));

    private SelenideElement deleteButton = $(By.id("click-to-delete"));

    private ElementsCollection emailsList = $$(By.xpath("//*[@id=\"mails\"]/tbody/tr/td[4]/a"));

    public void changeEmail() throws InterruptedException {
        open("https://temp-mail.ru/option/change");
        while (!login.isDisplayed()){
            Selenide.close();
            open("https://temp-mail.ru");
            changeButton.click();
            Thread.sleep(2000);//Костыль!
        }
        login.shouldBe(Condition.exist);
        login.setValue("qqq60");
        safeButton.click();
        //Почтовый адрес успешно сменен!
        $(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[1]")).shouldBe(Condition.visible);
    }

    public void delete(){
        deleteButton.click();
    }

    public void refresh() throws InterruptedException {
        refreshButton.click();
        while (emailsList.isEmpty()){
            emailsList = $$(By.xpath(".//*[@id='mails']/tbody"));
            System.out.println(emailsList.toString());
            refreshButton.click();
            Thread.sleep(2000);//Костыль!
        }
        System.out.println("Size "  + emailsList.size());
        System.out.println("123 " + emailsList.get(emailsList.size()-1).toString());
        emailsList.get(emailsList.size()-1).click();
    }

    public void registrationLinkClick() throws InterruptedException {
        changeEmail();
        delete();
        changeEmail();
        refresh();
        SelenideElement registrationLink = $(By.partialLinkText("lkdev"));
        registrationLink.click();
    }
}
