package com.ismailhakkiaydin.covid19.network.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Parcelable {

    @SerializedName("country")
    private String country;
    @SerializedName("cases")
    private Cases cases;
    @SerializedName("deaths")
    private Deaths deaths;
    @SerializedName("day")
    private String day;
    @SerializedName("time")
    private String time;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Cases getCases() {
        return cases;
    }

    public void setCases(Cases cases) {
        this.cases = cases;
    }

    public Deaths getDeaths() {
        return deaths;
    }

    public void setDeaths(Deaths deaths) {
        this.deaths = deaths;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.country);
        dest.writeParcelable(this.cases, flags);
        dest.writeParcelable(this.deaths, flags);
        dest.writeString(this.day);
        dest.writeString(this.time);
    }

    public Country() {
    }

    protected Country(Parcel in) {
        this.country = in.readString();
        this.cases = in.readParcelable(Cases.class.getClassLoader());
        this.deaths = in.readParcelable(Deaths.class.getClassLoader());
        this.day = in.readString();
        this.time = in.readString();
    }

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}