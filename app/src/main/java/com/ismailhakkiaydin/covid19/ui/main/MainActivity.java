package com.ismailhakkiaydin.covid19.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
    private RecyclerView recyclerView;
    private CountryViewModel countryViewModel;
  //  private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

       // final SwipeRefreshLayout mSwipeRefreshLayout = activityMainBinding.swipeRefreshLayout;
        RecyclerView recyclerView = activityMainBinding.recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        countryViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        recyclerViewLayout();


        countryAdapter = new CountryAdapter(this, countryList, new ItemClickListener() {
            @Override
            public void onItemClick(Country country, int position) {


            }
        });
        recyclerView.setAdapter(countryAdapter);


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