package com.ismailhakkiaydin.covid19.ui.favorite;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ismailhakkiaydin.covid19.network.dto.Country;

import java.util.List;

public class FollowedCountryViewModel extends AndroidViewModel {

    private FollowedCountryRepository followedCountryRepository;
    private LiveData<List<Country>> allFollowedCountries;

    public FollowedCountryViewModel(@NonNull Application application) {
        super(application);
        followedCountryRepository = new FollowedCountryRepository(application);
        allFollowedCountries = followedCountryRepository.getAllFollowedCountries();
    }

    public void insert(Country country){
        followedCountryRepository.insert(country);
    }

    public void delete(Country country){
        followedCountryRepository.delete(country);
    }

    public LiveData<List<Country>> getAllFollowedCountries(){
        return allFollowedCountries;
    }

}
