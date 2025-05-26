package com.example.apirecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {

    private Context context;
    private List<Countries> countriesList;
    public CountriesAdapter(Context context, List<Countries> countriesList) {
        this.context = context;
        this.countriesList = countriesList;
    }

    @NonNull
    @Override
    public CountriesAdapter.CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_countries, parent, false);
        return new CountriesAdapter.CountriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        Countries countries = countriesList.get(position);
        holder.tvtCountry.setText(countries.getName_en());
        Glide.with(holder.imgCountry.getContext())
                .load(countries.getFlag_url_32())
                .into(holder.imgCountry);
    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }

    public static class CountriesViewHolder extends RecyclerView.ViewHolder {
        TextView tvtCountry;
        ImageView imgCountry;

        public CountriesViewHolder(View itemView) {
            super(itemView);
            tvtCountry = itemView.findViewById(R.id.tvCountriesName);
            imgCountry = itemView.findViewById(R.id.ivBadge);
        }
    }
}
