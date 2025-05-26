package com.example.apirecycler;
import com.google.gson.annotations.SerializedName;
public class Countries {
    @SerializedName("name_en")
    private String name_en;

    @SerializedName("flag_url_32")
    private String flag_url_32;

    public String getName_en() {
        return name_en;
    }
    public String getFlag_url_32() {
        return flag_url_32;
    }
}
