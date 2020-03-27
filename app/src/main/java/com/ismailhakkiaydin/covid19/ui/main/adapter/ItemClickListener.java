package com.ismailhakkiaydin.covid19.ui.main.adapter;

import com.ismailhakkiaydin.covid19.network.dto.Country;

public interface ItemClickListener {
    void onItemClick(Country country, int position);
}
