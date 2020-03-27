package com.ismailhakkiaydin.covid19.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import com.ismailhakkiaydin.covid19.R;
import com.ismailhakkiaydin.covid19.databinding.ActivityMainBinding;
import com.ismailhakkiaydin.covid19.network.dto.Country;
import com.ismailhakkiaydin.covid19.ui.main.adapter.CountryAdapter;
import com.ismailhakkiaydin.covid19.ui.main.adapter.ItemClickListener;
import com.ismailhakkiaydin.covid19.ui.main.viewmodel.CountryViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CountryAdapter countryAdapter;
    private List<Country> countryList;
    private CountryViewModel countryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final SwipeRefreshLayout mSwipeRefreshLayout = activityMainBinding.swipeRefreshLayout;

        RecyclerView mRecyclerView = activityMainBinding.recyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        countryViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
        countryAdapter = new CountryAdapter(this, countryList, new ItemClickListener() {
            @Override
            public void onItemClick(Country country, int position) {

                CountryDialog countryDialog = new CountryDialog();
                Bundle bundle = new Bundle();
                bundle.putParcelable("country_detail", country);
                countryDialog.setArguments(bundle);
                countryDialog.show(getSupportFragmentManager(), "Country Dialog");
            }
        });
        mRecyclerView.setAdapter(countryAdapter);

        recyclerViewLayout();

        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_dark,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                R.color.colorPrimary);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerViewLayout();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });


        activityMainBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                countryAdapter.getFilter().filter(newText);
                return false;
            }
        });


    }

    private void recyclerViewLayout() {
        countryViewModel.getAllCountry().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
                countryAdapter.setCountryList(countries);
            }
        });
    }


}