package Selenium;

import Selenium.BaseTest.BaseTestWeb;
import com.dubtsov.safe.PageObject.Rules.RulesClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by user on 26.12.17.
 */
public class RuleTestWeb extends BaseTestWeb {

    RulesClass rulesClass;
    int before;

    @Before
    public void before() throws Exception {
        open("https://lkdev.safec.ru");

        authorisationPage.authorisationUser(login, password);
        rulesClass = new RulesClass();
        before = rulesClass.getRulesList().size();
    }

    @org.junit.Test
    public void addRule() throws InterruptedException {
        System.out.println("Число правил ДО добавления: " + before);
        rulesClass.closeRulesWindow();
        int after = rulesClass.addRule("Test").getRulesList().size();
        System.out.println("Число правил После добавления: " + after);
        rulesClass.closeRulesWindow();
        Assert.assertTrue(after - before == 1);
    }

    @org.junit.Test
    public void deleteRule() throws InterruptedException {
        rulesClass.closeRulesWindow();
        System.out.println("Число правил ДО удаления: " + before);
        if(before == 0){
            rulesClass.addRule("Test");
        }
        int after = rulesClass.deleteRule().getRulesList().size();
        System.out.println("Число правил После удаления: " + after);
        Assert.assertTrue(before - after == 1);
    }

}
