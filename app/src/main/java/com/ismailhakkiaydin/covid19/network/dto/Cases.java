package com.ismailhakkiaydin.covid19.network.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Cases implements Parcelable {

    @SerializedName("new")
    private String _new;
    @SerializedName("active")
    private Integer active;
    @SerializedName("critical")
    private Integer critical;
    @SerializedName("recovered")
    private Integer recovered;
    @SerializedName("total")
    private Integer total;

    public String getNew() {
        return _new;
    }

    public void setNew(String _new) {
        this._new = _new;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._new);
        dest.writeValue(this.active);
        dest.writeValue(this.critical);
        dest.writeValue(this.recovered);
        dest.writeValue(this.total);
    }

    public Cases() {
    }

    protected Cases(Parcel in) {
        this._new = in.readString();
        this.active = (Integer) in.readValue(Integer.class.getClassLoader());
        this.critical = (Integer) in.readValue(Integer.class.getClassLoader());
        this.recovered = (Integer) in.readValue(Integer.class.getClassLoader());
        this.total = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Cases> CREATOR = new Parcelable.Creator<Cases>() {
        @Override
        public Cases createFromParcel(Parcel source) {
            return new Cases(source);
        }

        @Override
        public Cases[] newArray(int size) {
            return new Cases[size];
        }
    };
}