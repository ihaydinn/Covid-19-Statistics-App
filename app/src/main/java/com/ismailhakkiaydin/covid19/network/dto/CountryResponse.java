package com.ismailhakkiaydin.covid19.network.dto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryResponse {



    @SerializedName("response")
    private List<Country> countryList = null;


    public List<Country> getCountryList() {
        return countryList;
    }
}