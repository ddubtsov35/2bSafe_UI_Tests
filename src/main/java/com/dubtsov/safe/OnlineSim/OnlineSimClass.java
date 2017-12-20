package com.dubtsov.safe.OnlineSim;

import com.dubtsov.safe.Response.ResponseClass;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Created by user on 30.10.17.
 */
public class OnlineSimClass {

    ResponseClass responseClass;

    public NumModel getNum() throws Exception {
        responseClass = new ResponseClass("http://onlinesim.ru/api/getNum.php?apikey=cc0a2357f6d6d10b95a600f76d7314a1&service=SMS");
        return GetNum.getNum(responseClass.getJsonResponse().body().string());
    }
}
