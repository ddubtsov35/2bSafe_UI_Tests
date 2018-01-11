package com.dubtsov.safe.PageObject.Profile.Web;

import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep1Template;
import com.dubtsov.safe.PageObject.AddProfileTemplate.AddProfileStep2Template;
import com.dubtsov.safe.PageObject.Map.MapPage;
import com.dubtsov.safe.PageObject.Map.Web.MapPageWeb;

/**
 * Created by user on 21.12.17.
 */
public class AddProfileWeb {

    public MapPage addProfile(MapPage mapPage) throws InterruptedException {
        AddProfileStep1Template addProfileStep1 = mapPage.addProfileClickButton();
        AddProfileStep2Template addProfileStep2 = addProfileStep1.addProfileStep1("TestName3", 10, "9183333333", "add");
        ResultWindowWeb resultWindow = addProfileStep2.selectSchoolConfirm();
        resultWindow.confirm();
        return new MapPage(new MapPageWeb());
    }

}
