package com.example.weatherapi;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class SampleController {
    // FXML elements injected from the FXML file
    @FXML
    private Button btnSearch;

    @FXML
    private Label errMsgLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private Text cityName;

    @FXML
    private Text temperature;

    @FXML
    private Text country;

    @FXML
    private ImageView weatherImage;

    @FXML
    private Text temp_c;

    @FXML
    private Text humidity;

    @FXML
    private Text wind_kph;

    @FXML
    private Text feelslike_c;

    // Method triggered when search button is clicked
    @FXML
    public void getSearchResults() {
        WeatherAPIService weatherService = new WeatherAPIService();
        try {
            // Get the search term from the text field
            String searchTerm = searchTextField.getText();

            // Make the API call to search for weather data
            String jsonInput = weatherService.searchWeatherByCity(searchTerm);

            // Log the received JSON response
            System.out.println("Received JSON response: " + jsonInput);

            // Parse the JSON response into a Weather object using Gson
            Gson gson = new Gson();
            Weather weather = gson.fromJson(jsonInput, Weather.class);

            // Check if the weather object and its components are not null
            if (weather != null && weather.getLocation() != null && weather.getCurrent() != null) {
                // Update UI elements with weather data

                // Update text elements with location and current weather details
                cityName.setText("City: " + weather.getLocation().getName());
                country.setText("Country: " + weather.getLocation().getCountry());
                feelslike_c.setText("Feels like: " + String.valueOf(weather.getCurrent().getFeelslike_c()));
                temperature.setText("Temperature in Celsius: " + String.valueOf(weather.getCurrent().getTemp_c()));
                humidity.setText("Humidity: " + String.valueOf(weather.getCurrent().getHumidity()));
                wind_kph.setText("Wind in kph : " + String.valueOf(weather.getCurrent().getWind_kph()));

                // Update weather image
                updateWeatherImage(weather.getCurrent().getCondition().getIcon());

            } else {
                // Display error message if no weather data found
                errMsgLabel.setText("Error: No weather data found");
            }
        } catch (IOException | InterruptedException e) {
            // Display error message if failed to retrieve weather data
            errMsgLabel.setText("Error: Failed to retrieve weather data");
            // Log the error
            e.printStackTrace();
        }
    }

    // Method to update weather image in the ImageView
    public void updateWeatherImage(String iconUrl) {
        // Set the image in the ImageView
        if (iconUrl != null && !iconUrl.isEmpty()) {
            // Prepend "https:" to the iconUrl if it starts with "//"
            if (iconUrl.startsWith("//")) {
                iconUrl = "https:" + iconUrl;
            }
            // Load the image from the iconUrl and set it in the ImageView
            Image image = new Image(iconUrl);
            weatherImage.setImage(image);
        }
    }

}
