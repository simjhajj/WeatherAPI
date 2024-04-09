package com.example.weatherapi;

import java.util.List;

public class SearchResult {
    // List to store search results
    private List<Weather> search;

    // Getter for search results
    public List<Weather> getSearch() {
        return search;
    }

    // Setter for search results
    public void setSearch(List<Weather> search) {
        this.search = search;
    }

    // Custom toString method to display search results
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Search Result:\n");
        // Check if search results are not null and not empty
        if (search != null && !search.isEmpty()) {
            // Iterate through each weather object in the search results
            for (Weather weather : search) {
                // Append city name, temperature, country, weather condition, and feels-like temperature
                sb.append("City: ").append(weather.getLocation().getName()).append("\n");
                sb.append("Temperature in Celsius: ").append(weather.getCurrent().getTemp_c()).append("\n");
                sb.append("Country: ").append(weather.getLocation().getCountry()).append("\n");
                sb.append("Weather Condition: ").append(weather.getCurrent().getCondition().getText()).append("\n");
                sb.append("Feels Like Temperature (C): ").append(weather.getCurrent().getFeelslike_c()).append("\n");
                // Additional information like humidity and wind speed
                sb.append("Humidity: ").append(weather.getCurrent().getHumidity()).append("\n");
                sb.append("Wind Speed (kph): ").append(weather.getCurrent().getWind_kph()).append("\n");
                sb.append("\n");
            }
        } else {
            // If no search results found, display appropriate message
            sb.append("No search results found.\n");
        }
        // Convert StringBuilder to string and return
        return sb.toString();
    }
}
