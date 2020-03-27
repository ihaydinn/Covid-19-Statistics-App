package com.ismailhakkiaydin.covid19.ui.main.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ismailhakkiaydin.covid19.databinding.ListItemBinding;
import com.ismailhakkiaydin.covid19.network.dto.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> implements Filterable {

    private Context context;
    private ItemClickListener mItemClickListener;
    private List<Country> countryList;
    private List<Country> tempCountryList;


    public CountryAdapter(Context mContext, List<Country> countryList, ItemClickListener mItemClickListener) {
        this.context = mContext;
        this.countryList = countryList;
        this.tempCountryList = countryList;
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ListItemBinding mListItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        final CountryViewHolder countryViewHolder = new CountryViewHolder(mListItemBinding);

        mListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(countryList.get(countryViewHolder.getAdapterPosition()), countryViewHolder.getAdapterPosition());

            }
        });


        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country mCountry = tempCountryList.get(position);
        holder.mListItemBinding.setDetail(mCountry);
        holder.mListItemBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        if (tempCountryList != null) {
            return tempCountryList.size();
        } else {
            return 0;
        }
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
        this.tempCountryList = countryList;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {

       return new Filter() {

           FilterResults filterResults;

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();

                if (searchString.isEmpty()) {
                    tempCountryList = countryList;
                } else {
                    List<Country> filteredList = new ArrayList<>();
                    for (Country country : countryList) {
                        if (country.getCountry().toLowerCase().contains(searchString.toLowerCase())) {
                            filteredList.add(country);
                              Log.e("ERORR ", ""+country.getCountry());
                        }
                    }
                    tempCountryList = filteredList;
                }
                 Log.v("Result", "" + tempCountryList.size());
                filterResults = new FilterResults();
                filterResults.values = tempCountryList;
                filterResults.count = tempCountryList.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                tempCountryList = (List<Country>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        private ListItemBinding mListItemBinding;

        public CountryViewHolder(@NonNull ListItemBinding mListItemBinding) {
            super(mListItemBinding.getRoot());

            this.mListItemBinding = mListItemBinding;
        }
    }
}