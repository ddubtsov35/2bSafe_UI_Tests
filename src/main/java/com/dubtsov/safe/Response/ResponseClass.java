package com.dubtsov.safe.Response;

import com.dubtsov.safe.GetCodeActivationAccount.GetCodeActivationAccount;
import com.squareup.okhttp.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * Created by user on 30.10.17.
 */
public class ResponseClass {
    private OkHttpClient client = new OkHttpClient();
    private Response response;
    private String url;
    private JSONObject jsonRequest;
    private static String sessionId = "";
    private String postmanToken = "6890b6c8-e300-4787-0233-b79a28139bf3";

    public ResponseClass(String url) throws ParseException {
        this.url = url;
    }

    public ResponseClass(String url, JSONObject jsonObject) throws ParseException {
        this.url = url;
        this.jsonRequest = jsonObject;
    }

    private Request getRequest(){
        Request request = new Request.Builder()
                .url(url)
                .build();
        System.out.println("Request " + request.toString());
        return request;
    }

    private Request getJsonRequest(){
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, String.valueOf(jsonRequest));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", postmanToken)
                .addHeader("cookie", sessionId)
                .build();
        System.out.println(request.toString());
        System.out.println("RequestJson " + String.valueOf(jsonRequest));
        return request;
    }


    public Response getJsonResponse() throws Exception {
        response = client.newCall(getJsonRequest()).execute();
        try {
            String sessionId = getSessionId(response.headers().toString());
            setSessionId(sessionId);
        } catch (StringIndexOutOfBoundsException e){
            return response;
        } finally {
            System.out.println(response);
            System.out.println();
        }
        //System.out.println("JsonResponse " + response.toString());
        return response;
    }

    public Response getResponse() throws IOException {
        response = client.newCall(getRequest()).execute();
        System.out.println("Response " + response.toString());
        return response;
    }


    public String getSessionId(String headersString){
        int sessionIdPositionStart = headersString.indexOf("session_id=");
        int sessionIdPositionFinish = headersString.indexOf(";", sessionIdPositionStart);
        sessionId = headersString.substring(sessionIdPositionStart, sessionIdPositionFinish);
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
