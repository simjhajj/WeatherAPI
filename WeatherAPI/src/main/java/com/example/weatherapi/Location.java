package com.example.weatherapi;

import com.google.gson.annotations.SerializedName;

public class Location {
    // Instance variables
    @SerializedName("name")
    private String name; // Name of the location (e.g., city)

    @SerializedName("country")
    private String country; // Country of the location

    // Constructors
    public Location(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // Getter for name
    public String getName() {
        return name; // Returns the name of the location
    }

    // Setter for name
    public void setName(String name) {
        this.name = name; // Sets the name of the location
    }

    // Getter for country
    public String getCountry() {
        return country; // Returns the country of the location
    }

    // Setter for country
    public void setCountry(String country) {
        this.country = country; // Sets the country of the location
    }
}
