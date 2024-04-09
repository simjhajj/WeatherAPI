package com.example.weatherapi;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WeatherAPIService {
    // API key and base URL for weather API
    private static final String API_KEY = "3adfbf9d34b24500a7c193209230612";
    private static final String BASE_URL = "https://api.weatherapi.com/v1/current.json";

    // Method to search weather by city name
    public String searchWeatherByCity(String cityName) throws IOException, InterruptedException {
        // Encode city name to handle special characters in URL
        String encodedCityName = URLEncoder.encode(cityName, StandardCharsets.UTF_8);
        // Construct API URL with API key and encoded city name
        String apiUrl = String.format("%s?key=%s&q=%s", BASE_URL, API_KEY, encodedCityName);
        // Send HTTP request to API endpoint and return response
        return sendHttpRequest(apiUrl);
    }

    // Method to send HTTP request and handle response
    private String sendHttpRequest(String url) throws IOException, InterruptedException {
        // Create new HttpClient instance
        HttpClient client = HttpClient.newHttpClient();
        // Build HTTP request with provided URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        // Send request and receive response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Return response body
        return response.body();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create instance of WeatherAPIService
        WeatherAPIService weatherService = new WeatherAPIService();
        try {
            // Example city to search for weather information
            String city = "Toronto";
            // Make the API call and print response
            String response = weatherService.searchWeatherByCity(city);
            System.out.println(response);
        } catch (IOException | InterruptedException e) {
            // Handle any IO or Interrupted exceptions
            e.printStackTrace();
        }
    }
}
