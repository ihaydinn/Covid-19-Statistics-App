package com.ismailhakkiaydin.covid19.network.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deaths implements Parcelable {

    @SerializedName("new")
    private String _new;
    @SerializedName("total")
    private Integer total;

    public String getNew() {
        return _new;
    }

    public void setNew(String _new) {
        this._new = _new;
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
        dest.writeValue(this.total);
    }

    public Deaths() {
    }

    protected Deaths(Parcel in) {
        this._new = in.readString();
        this.total = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Deaths> CREATOR = new Parcelable.Creator<Deaths>() {
        @Override
        public Deaths createFromParcel(Parcel source) {
            return new Deaths(source);
        }

        @Override
        public Deaths[] newArray(int size) {
            return new Deaths[size];
        }
    };
}