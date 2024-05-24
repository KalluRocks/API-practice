package com.demo2;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class App {
    public static void main( String[] args ) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String symbol = "MSFT";
        String endpoint = String.format("https://alpha-vantage.p.rapidapi.com/query?function=TIME_SERIES_DAILY&symbol=%s&outputsize=compact&datatype=json", symbol); 
        Request request = new Request.Builder()
            .url(endpoint)
            .get()
            .addHeader("X-RapidAPI-Key", "api key here")
            .addHeader("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
            .build();

        Response response = client.newCall(request).execute();
        
        System.out.println(response);
        System.out.println(response.body().string());

        //Close the connection with client
        response.close();
    }
}
