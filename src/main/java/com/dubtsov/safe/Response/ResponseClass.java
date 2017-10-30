package com.dubtsov.safe.Response;

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

    public ResponseClass(String url) throws ParseException {
        this.url = url;
    }

    private Request getJsonRequest(){
        Request request = new Request.Builder()
                .url(url)
                .build();
        System.out.println("Request " + request.toString());
        return request;
    }


    public Response getJsonResponse() throws IOException {
        response = client.newCall(getJsonRequest()).execute();
        System.out.println("Response " + response.toString());
        return response;
    }

}
