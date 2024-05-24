package com.demo2;

import java.io.IOException;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

public class Asyncexample {
    public static void main(String[] args) throws IOException {
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        String symbol = "SBIN.BSE";
        String endpoint = String.format("https://alpha-vantage.p.rapidapi.com/query?function=TIME_SERIES_DAILY&symbol=%s&outputsize=compact&datatype=json", symbol); 
        client.prepare("GET", endpoint)
	        .setHeader("X-RapidAPI-Key", "api key here")
	        .setHeader("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
	        .execute()
	        .toCompletableFuture()
	        .thenAccept(System.out::println)
	        .join();

        client.close();
    }    
}
