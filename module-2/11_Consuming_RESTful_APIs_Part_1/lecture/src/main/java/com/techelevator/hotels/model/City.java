package com.techelevator.hotels.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {

    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("geoname_id")
    private int geonameId;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(int geonameId) {
        this.geonameId = geonameId;
    }

    @Override
    public String toString(){
        return fullName;
    }

}
