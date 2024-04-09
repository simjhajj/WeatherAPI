package com.example.weatherapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file containing the UI layout
            Parent root = FXMLLoader.load(getClass().getResource("weather-view.fxml"));

            // Set the title of the primary stage
            primaryStage.setTitle("Weather App");

            // Load the application icon
            Image icon = new Image(getClass().getResourceAsStream("/com/example/weatherAPI/images/clear.png"));

            // Set the application icon for the primary stage
            primaryStage.getIcons().add(icon);

            // Create a new scene with the root node and set its dimensions
            primaryStage.setScene(new Scene(root, 610, 684));

            // Show the primary stage
            primaryStage.show();
        } catch (Exception e) {
            // Print stack trace if an exception occurs during application startup
            e.printStackTrace();
        }
    }

    // Entry point of the application
    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}
