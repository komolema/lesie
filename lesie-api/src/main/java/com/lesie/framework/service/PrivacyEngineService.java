package com.lesie.framework.service;


import com.google.gson.Gson;
import com.lesie.framework.request.SharingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrivacyEngineService {

    public static String PE_URL = "http://localhost:8181";
    public static String PE_CAN_SHARE = "/cxf/api/V1/canmove";

    private HttpClient httpClient;
    private HttpResponse response;

    public PrivacyEngineService(){
        init();
    }

    public String canShare(SharingRequest request) throws Exception{
        String result = "";
        HttpPost httpRequest = new HttpPost(PrivacyEngineService.PE_URL
                + PrivacyEngineService.PE_CAN_SHARE);
        httpRequest.addHeader("accept", "application/json");
        httpRequest.addHeader("content-type", "application/json");

        Gson gson = new Gson();
        String json = gson.toJson(request);

        StringEntity se = new StringEntity(json.toString());
        httpRequest.setEntity(se);

        try {
            response = httpClient.execute(httpRequest);
            if(response.getStatusLine().getStatusCode() == 200) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent())
                );
            }
            else{
                result = "F";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    };

    public void init(){
        httpClient = HttpClientBuilder.create().build();

    }
}
