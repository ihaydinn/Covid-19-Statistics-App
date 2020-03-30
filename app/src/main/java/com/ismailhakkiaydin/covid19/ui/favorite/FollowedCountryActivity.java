package com.ismailhakkiaydin.covid19.ui.favorite;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ismailhakkiaydin.covid19.R;
import com.ismailhakkiaydin.covid19.databinding.ActivityFollowedCountryBinding;
import com.ismailhakkiaydin.covid19.network.dto.Country;

import java.util.List;

public class FollowedCountryActivity extends AppCompatActivity {

    private FollowedCountryAdapter followedCountryAdapter;
    private FollowedCountryViewModel followedCountryViewModel;
    private List<Country> countryList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFollowedCountryBinding activityFollowedCountryBinding = DataBindingUtil.setContentView(this, R.layout.activity_followed_country);

        RecyclerView recyclerView = activityFollowedCountryBinding.recyclerviewFollowedCountry;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        followedCountryViewModel = ViewModelProviders.of(this).get(FollowedCountryViewModel.class);
        followedCountryAdapter = new FollowedCountryAdapter(this, countryList);
        recyclerView.setAdapter(followedCountryAdapter);

        followedCountryViewModel.getAllFollowedCountries().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countryList) {
                followedCountryAdapter.setCountryList(countryList);
            }
        });


    }
}
