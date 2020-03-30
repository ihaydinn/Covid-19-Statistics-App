package com.ismailhakkiaydin.covid19.network.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.ismailhakkiaydin.covid19.network.dto.Country;

import java.util.List;

@Dao
public interface CountryDao {

    @Insert
    void insert(Country country);

    @Delete
    void delete(Country country);

    @Query("SELECT * FROM followed_country")
    LiveData<List<Country>> getAllFollowedCountries();

}
