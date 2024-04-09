package com.example.weatherapi;

import com.google.gson.annotations.SerializedName;

public class Weather {
    // Define instance variables
    @SerializedName("location")
    private Location location; // Location object containing location information

    @SerializedName("current")
    private Current current; // Current object containing current weather information

    // Constructors
    public Weather(Location location, Current current) {
        this.location = location;
        this.current = current;
    }

    // Getters and setters for location
    public Location getLocation() {
        return location; // Returns the location object
    }

    public void setLocation(Location location) {
        this.location = location; // Sets the location object
    }

    // Getters and setters for current weather
    public Current getCurrent() {
        return current; // Returns the current weather object
    }

    public void setCurrent(Current current) {
        this.current = current; // Sets the current weather object
    }
}
