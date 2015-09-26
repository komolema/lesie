package com.lesie.framework.service;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrivacyEngineService {

    public static String PE_URL = "http://httpbin.org";
    public static String PE_CAN_SHARE = "/ip";

    private HttpClient httpClient;
    private HttpResponse response;

    public PrivacyEngineService(){
        init();
    }

    public String canShare(String thirdPartyKey, String dataHolderKey, String dataOwnerKey){
        String result = "";
        HttpGet request = new HttpGet(PrivacyEngineService.PE_URL
                + PrivacyEngineService.PE_CAN_SHARE);
        request.addHeader("accept", "application/json");

        try {
            response = httpClient.execute(request);
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
