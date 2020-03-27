package com.ismailhakkiaydin.covid19.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.ismailhakkiaydin.covid19.R;
import com.ismailhakkiaydin.covid19.databinding.CountryDialogBoxBinding;
import com.ismailhakkiaydin.covid19.network.dto.Country;

public class CountryDialog extends DialogFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        CountryDialogBoxBinding countryDialogBoxBinding = DataBindingUtil.inflate(inflater, R.layout.country_dialog_box, container, false);
        View view = countryDialogBoxBinding.getRoot();

        Country country = getArguments().getParcelable("country_detail");
        countryDialogBoxBinding.setCountry(country);


        return view;
    }

}
