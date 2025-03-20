package com.CurrencyConverter.WorldCurrencyConverter.Service;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;


import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GetRates {
    
    public static void getAllRates() throws IOException {
        // gets all rates and saves them to rates.json
        OkHttpClient client = new OkHttpClient();
        String key = "YOUR-API-KEY";

        // Create form data with parameters
        RequestBody requestBody = new FormBody.Builder()
                .add("symbol", "all_forex")
                .add("access_key", key)
                .build();

        // Create the request
        Request request = new Request.Builder()
                .url("https://fcsapi.com/api-v3/forex/latest?")
                .post(requestBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        if (response.isSuccessful()) {
            
            String responseBody = response.body().string();
            JSONObject jsonObject = new JSONObject(responseBody);
            String formattedJson = jsonObject.toString(2);
            try (FileWriter fileWriter = new FileWriter("rates.json")) {
                fileWriter.write(formattedJson);
            } catch (IOException e) {
                System.err.println("Error saving JSON response to file: " + e.getMessage());
            }
        }
    }
}
