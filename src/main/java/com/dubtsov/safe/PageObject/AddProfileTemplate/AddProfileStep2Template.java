package com.dubtsov.safe.PageObject.AddProfileTemplate;

import com.codeborne.selenide.SelenideElement;
import com.dubtsov.safe.PageObject.MapPage;
import com.dubtsov.safe.PageObject.Profile.ResultWindow;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by user on 21.12.17.
 */
public class AddProfileStep2Template {

    protected String path;

    protected SelenideElement inputFild;

    protected List<SelenideElement> schoolList;

    protected SelenideElement classField;

    protected SelenideElement wordField;

    protected SelenideElement cancelButton;

    protected SelenideElement successButton;

    public ResultWindow selectSchoolConfirm() throws InterruptedException {
        inputFild.click();
        schoolList.get(1).click();
        classField.setValue("11");
        wordField.setValue("А");
        successButton.click();
        return new ResultWindow();
    }

}
