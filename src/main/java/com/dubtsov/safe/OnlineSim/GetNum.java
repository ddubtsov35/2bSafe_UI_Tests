package com.dubtsov.safe.OnlineSim;

import org.json.simple.parser.ParseException;

/**
 * Created by user on 30.10.17.
 */
public class GetNum {

    private static NumModel numModel;

    public static NumModel getNum(String getNumString){
        try {
            System.out.println(getNumString);
            numModel = new NumModel(getNumString);
        } catch (ParseException e){}
        finally {
            return numModel;
        }
    }

}
