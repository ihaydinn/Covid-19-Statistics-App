package com.ismailhakkiaydin.covid19.ui.main.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ismailhakkiaydin.covid19.databinding.ListItemBinding;
import com.ismailhakkiaydin.covid19.network.dto.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private Context context;
    private ItemClickListener mItemClickListener;
    private List<Country> countryList;


    public CountryAdapter(Context context, List<Country> countryList, ItemClickListener mItemClickListener) {
        this.context = context;
        this.countryList = countryList;
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ListItemBinding mListItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
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
    public void onBindViewHolder(CountryAdapter.CountryViewHolder holder, int position) {

        Country mCountry = countryList.get(position);
        holder.mListItemBinding.setCountry(mCountry);
        holder.mListItemBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        if (countryList != null){
            return countryList.size();
        }
        else return 0;
    }

    public void setCountryList(List<Country> countryList){
        this.countryList = countryList;
        notifyDataSetChanged();
    }


    public class CountryViewHolder extends RecyclerView.ViewHolder {


        private ListItemBinding mListItemBinding;

        public CountryViewHolder(@NonNull ListItemBinding mListItemBinding) {
            super(mListItemBinding.getRoot());

            this.mListItemBinding = mListItemBinding;
        }
    }
}