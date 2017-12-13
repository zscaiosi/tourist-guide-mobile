package com.example.caio.touristguideapp.Model;

/**
 * Created by caio on 12/12/17.
 */

public class Place {
    private String name, address, country;

    public Place(String... params){
        this.name = params[0];
        this.address = params[1];
        this.country = params[2];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }
}
