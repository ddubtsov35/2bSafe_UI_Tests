package com.dubtsov.safe.TempMail;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 30.10.17.
 */
public class GetMail {

    private static List<MailModel> mailModel;
    private static JSONParser parser;
    private static Object obj;
    private static JSONObject jsonObj;
    private static JSONArray jsonArray;


    public static List<MailModel> getMail(String accountSettingsString) throws ParseException, java.text.ParseException {
        try {
            mailModel = new ArrayList<MailModel>();
            parser = new JSONParser();
            obj = parser.parse(accountSettingsString);
            jsonArray = (JSONArray) obj;

            for(int i = 0; i < jsonArray.size(); i++) {
                mailModel.add(new MailModel(jsonArray.get(i).toString()));
            }
        } catch (ParseException e){}
        finally {
            return mailModel;
        }
    }

}
