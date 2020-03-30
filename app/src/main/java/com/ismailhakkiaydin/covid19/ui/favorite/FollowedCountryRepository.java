package com.ismailhakkiaydin.covid19.ui.favorite;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.ismailhakkiaydin.covid19.network.dto.Country;
import com.ismailhakkiaydin.covid19.network.local.CountryDao;
import com.ismailhakkiaydin.covid19.network.local.CountryDatabase;

import java.util.List;

public class FollowedCountryRepository {

    private CountryDao countryDao;
    private LiveData<List<Country>> allFollowedCountries;

    public FollowedCountryRepository(Application application){
        CountryDatabase countryDatabase = CountryDatabase.getInstance(application);
        countryDao = countryDatabase.countryDao();
        allFollowedCountries = countryDao.getAllFollowedCountries();
    }

    public void insert(Country country){
        new InsertFollowedCountryAsyncTask(countryDao).execute(country);
    }

    public void delete(Country country){
        new DeleteFollowedCountryAsyncTask(countryDao).execute(country);
    }

    public LiveData<List<Country>> getAllFollowedCountries(){
        return allFollowedCountries;
    }

    private static class InsertFollowedCountryAsyncTask extends AsyncTask<Country, Void, Void>{
        private CountryDao countryDao;
        private InsertFollowedCountryAsyncTask(CountryDao countryDao){
            this.countryDao = countryDao;
        }

        @Override
        protected Void doInBackground(Country... countries) {
            countryDao.insert(countries[0]);
            return null;
        }
    }

    private static class DeleteFollowedCountryAsyncTask extends AsyncTask<Country, Void, Void>{
        private CountryDao countryDao;
        private DeleteFollowedCountryAsyncTask(CountryDao countryDao){
            this.countryDao = countryDao;
        }

        @Override
        protected Void doInBackground(Country... countries) {
            countryDao.delete(countries[0]);
            return null;
        }
    }

}
