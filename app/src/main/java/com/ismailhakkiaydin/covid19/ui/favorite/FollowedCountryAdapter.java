package com.ismailhakkiaydin.covid19.ui.favorite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ismailhakkiaydin.covid19.databinding.ActivityFollowedCountryBinding;
import com.ismailhakkiaydin.covid19.databinding.ListItemBinding;
import com.ismailhakkiaydin.covid19.network.dto.Country;

import java.util.List;

public class FollowedCountryAdapter extends RecyclerView.Adapter<FollowedCountryAdapter.FollowedCountryViewHolder> {

    private Context context;
    private List<Country> listFollowedCountries;

    public FollowedCountryAdapter(Context context, List<Country> listFollowedCountries) {
        this.context = context;
        this.listFollowedCountries = listFollowedCountries;
    }

    @NonNull
    @Override
    public FollowedCountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ListItemBinding mListItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        final FollowedCountryViewHolder followedCountryViewHolder = new FollowedCountryViewHolder(mListItemBinding);

        return followedCountryViewHolder;
    }

    
    @Override
    public void onBindViewHolder(@NonNull FollowedCountryViewHolder holder, int position) {
        Country country = listFollowedCountries.get(position);
        holder.mListItemBinding.setDetail(country);
        holder.mListItemBinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        if (listFollowedCountries != null) {
            return listFollowedCountries.size();
        } else {
            return 0;
        }
    }

    public void setCountryList(List<Country> countryList) {
        this.listFollowedCountries = countryList;
        notifyDataSetChanged();
    }

    public class FollowedCountryViewHolder extends RecyclerView.ViewHolder {
        private ListItemBinding mListItemBinding;
        public FollowedCountryViewHolder(@NonNull ListItemBinding mListItemBinding) {
            super(mListItemBinding.getRoot());
            this.mListItemBinding = mListItemBinding;
        }
    }
}
