package com.example.apirecycler;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class CountriesResponse {
    @SerializedName("countries")
    private List<Countries> countries;

    public List<Countries> getCountries() {
        return countries;
    }
}
