package com.dubtsov.safe.TempMail;

import com.typesafe.config.ConfigException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.html.parser.Parser;

/**
 * Created by user on 30.10.17.
 */
public class MailModel {

    private Integer mail_unique_id;

    private String mail_id;

    private String mail_address_id;

    private String mail_from;

    private String mail_subject;

    private String mail_preview;

    private String mail_text_only;

    private String mail_text;

    private String mail_html;

    private String link;


    private JSONParser parser;
    private Object obj;
    private JSONObject jsonObj;
    public MailModel(String jsonObjectString) throws ParseException, java.text.ParseException {
        setObject(jsonObjectString);
    }

    private void setObject(String jsonObjectString) throws ParseException, java.text.ParseException {
        Pattern pattern = Pattern.compile("[0-9]");

        parser = new JSONParser();
        obj = parser.parse(jsonObjectString);
        jsonObj = (JSONObject) obj;



        try {
            if (jsonObj.get("mail_unique_id") != null) { setMail_unique_id(Integer.parseInt(jsonObj.get("mail_unique_id").toString())); } else{setMail_unique_id(null);}
            if (jsonObj.get("mail_id") != null) { setMail_id(jsonObj.get("mail_id").toString()); } else{setMail_id(null);}
            if (jsonObj.get("mail_address_id") != null) { setMail_address_id(jsonObj.get("mail_address_id").toString()); } else{setMail_address_id(null);}
            if (jsonObj.get("mail_from") != null) { setMail_from(jsonObj.get("mail_from").toString()); } else{setMail_unique_id(null);}
            if (jsonObj.get("mail_subject") != null) { setMail_subject(jsonObj.get("mail_subject").toString()); } else{setMail_subject(null);}
            if (jsonObj.get("mail_preview") != null) { setMail_preview(jsonObj.get("mail_preview").toString()); } else{setMail_preview(null);}
            if (jsonObj.get("mail_text_only") != null) { setMail_text_only(jsonObj.get("mail_text_only").toString()); } else{setMail_text_only(null);}
            if (jsonObj.get("mail_text") != null) { setMail_text(jsonObj.get("mail_text").toString()); } else{setMail_text(null);}
            if (jsonObj.get("mail_html") != null) { setMail_html(jsonObj.get("mail_html").toString()); } else{setMail_html(null);}

            System.out.println(getMail_text());
            Matcher m = pattern.matcher(getMail_text());
            try {
                System.out.println(m.matches());}
            catch (Exception e){System.out.println("Нет ссылки!");}

        } catch (Exception e){
            setMail_unique_id(null);
            setMail_id(null);
            setMail_address_id(null);
            setMail_from(null);
            setMail_subject(null);
            setMail_preview(null);
            setMail_text_only(null);
            setMail_text(null);
            setMail_html(null);
        }
    }

    @Override
    public String toString() {
        return "MailModel{" +
                "mail_unique_id=" + mail_unique_id +
                ", mail_id=" + mail_id +
                ", mail_address_id='" + mail_address_id + '\'' +
                ", mail_from='" + mail_from + '\'' +
                ", mail_subject='" + mail_subject + '\'' +
                ", mail_preview='" + mail_preview + '\'' +
                ", mail_text_only='" + mail_text_only + '\'' +
                ", mail_text='" + mail_text + '\'' +
                ", mail_html='" + mail_html + '\'' +
                '}';
    }

    public Integer getMail_unique_id() {
        return mail_unique_id;
    }

    public void setMail_unique_id(Integer mail_unique_id) {
        this.mail_unique_id = mail_unique_id;
    }

    public String getMail_id() {
        return mail_id;
    }

    public void setMail_id(String mail_id) {
        this.mail_id = mail_id;
    }

    public String getMail_address_id() {
        return mail_address_id;
    }

    public void setMail_address_id(String mail_address_id) {
        this.mail_address_id = mail_address_id;
    }

    public String getMail_from() {
        return mail_from;
    }

    public void setMail_from(String mail_from) {
        this.mail_from = mail_from;
    }

    public String getMail_subject() {
        return mail_subject;
    }

    public void setMail_subject(String mail_subject) {
        this.mail_subject = mail_subject;
    }

    public String getMail_preview() {
        return mail_preview;
    }

    public void setMail_preview(String mail_preview) {
        this.mail_preview = mail_preview;
    }

    public String getMail_text_only() {
        return mail_text_only;
    }

    public void setMail_text_only(String mail_text_only) {
        this.mail_text_only = mail_text_only;
    }

    public String getMail_text() {
        return mail_text;
    }

    public void setMail_text(String mail_text) {
        this.mail_text = mail_text;
    }

    public String getMail_html() {
        return mail_html;
    }

    public void setMail_html(String mail_html) {
        this.mail_html = mail_html;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
