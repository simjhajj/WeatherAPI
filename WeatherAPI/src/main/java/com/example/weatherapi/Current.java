package com.example.weatherapi;

import com.google.gson.annotations.SerializedName;

public class Current {
    // Instance variables
    @SerializedName("temp_c")
    private double temp_c; // Temperature in Celsius

    @SerializedName("humidity")
    private int humidity; // Humidity percentage

    @SerializedName("wind_kph")
    private double wind_kph; // Wind speed in kilometers per hour

    @SerializedName("feelslike_c")
    private double feelslike_c; // Feels like temperature in Celsius

    private Condition condition; // Nested condition object representing weather condition

    // Constructor
    public Current(double temp_c, int humidity, double wind_kph, double feelslike_c, Condition condition) {
        this.temp_c = temp_c;
        this.humidity = humidity;
        this.wind_kph = wind_kph;
        this.feelslike_c = feelslike_c;
        this.condition = condition;
    }

    // Getters and setters for instance variables
    public double getTemp_c() {
        return temp_c; // Returns the temperature in Celsius
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c; // Sets the temperature in Celsius
    }

    public int getHumidity() {
        return humidity; // Returns the humidity percentage
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity; // Sets the humidity percentage
    }

    public double getWind_kph() {
        return wind_kph; // Returns the wind speed in kilometers per hour
    }

    public void setWind_kph(double wind_kph) {
        this.wind_kph = wind_kph; // Sets the wind speed in kilometers per hour
    }

    public double getFeelslike_c() {
        return feelslike_c; // Returns the feels like temperature in Celsius
    }

    public void setFeelslike_c(double feelslike_c) {
        this.feelslike_c = feelslike_c; // Sets the feels like temperature in Celsius
    }

    public Condition getCondition() {
        return condition; // Returns the nested Condition object representing weather condition
    }

    public void setCondition(Condition condition) {
        this.condition = condition; // Sets the nested Condition object representing weather condition
    }

    // Nested Condition class representing weather condition
    public static class Condition {
        private String text; // Description of the weather condition
        private String icon; // URL for the icon representing the weather condition

        // Getters and setters for Condition instance variables
        public String getText() {
            return text; // Returns the description of the weather condition
        }

        public void setText(String text) {
            this.text = text; // Sets the description of the weather condition
        }

        public String getIcon() {
            return icon; // Returns the URL for the icon representing the weather condition
        }

        public void setIcon(String icon) {
            this.icon = icon; // Sets the URL for the icon representing the weather condition
        }

        // toString method for Condition class
        @Override
        public String toString() {
            return "Condition{" +
                    "text='" + text + '\'' +
                    ", icon='" + icon + '\'' +
                    '}';
        }
    }
}
