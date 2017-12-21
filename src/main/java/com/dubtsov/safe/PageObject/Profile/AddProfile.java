package com.dubtsov.safe.PageObject.Profile;

import com.dubtsov.safe.PageObject.MapPage;

/**
 * Created by user on 21.12.17.
 */
public class AddProfile {

    public MapPage addProfile(MapPage mapPage) throws InterruptedException {
        AddProfileStep1 addProfileStep1 = mapPage.addProfileClickButton();
        AddProfileStep2 addProfileStep2 = addProfileStep1.addProfileStep1("TestName3", 10, "9183333333");
        ResultWindow resultWindow = addProfileStep2.selectSchoolConfirm();
        resultWindow.confirm();
        return new MapPage();
    }

}
