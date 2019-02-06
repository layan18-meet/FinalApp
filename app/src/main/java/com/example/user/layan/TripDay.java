package com.example.user.layan;

import java.util.ArrayList;

public class TripDay {

    private String country;
    private int image;
    private int tripDayId;
    private ArrayList<String> cities;
    private String description;


    public TripDay(String country, String city, String description,int image) {
        this.country=country;
        this.image=image;
        this.description=description;
        cities= new ArrayList<String>();

    }

    public String getCountry() {
        return country;
    }

    public int getImage() {

        return image;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<String> getCities() {
        return this.cities;
    }

    public void addCity(String city) {
        this.cities.add(city);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image=image;
    }


}
