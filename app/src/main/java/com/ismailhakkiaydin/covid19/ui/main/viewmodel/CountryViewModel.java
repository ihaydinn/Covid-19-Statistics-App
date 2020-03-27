package com.ismailhakkiaydin.covid19.ui.main.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ismailhakkiaydin.covid19.network.dto.Country;
import com.ismailhakkiaydin.covid19.repository.CountryRepository;

import java.util.List;

public class CountryViewModel extends AndroidViewModel {

    private CountryRepository countryRepository;

    public CountryViewModel(@NonNull Application application) {
        super(application);
        countryRepository  = new CountryRepository();
    }

    public LiveData<List<Country>> getAllCountry(){
        return countryRepository.getMutableLiveData();
    }

}
