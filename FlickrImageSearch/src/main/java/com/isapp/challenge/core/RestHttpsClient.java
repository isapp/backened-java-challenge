package com.isapp.challenge.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;

public class RestHttpsClient 
{

    public JSONObject RestGetJson(String urlInfo) 
    {
        JSONObject result = new JSONObject();
        try 
        {
            URL url = new URL(urlInfo);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            BufferedReader br =
                new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            StringBuilder responseBuilder = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                responseBuilder.append(output);
            }
            result = new JSONObject(responseBuilder.toString());
            br.close();
        } catch (ClientProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


}