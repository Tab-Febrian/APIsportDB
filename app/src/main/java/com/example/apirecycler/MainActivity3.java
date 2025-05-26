package com.example.apirecycler;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;;

public class MainActivity3 extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadTeamsS();
    }

    private void loadTeamsS() {
        APIClient.getApiClient().getAllCountries()
                .enqueue(new Callback<CountriesResponse>() {
                    @Override
                    public void onResponse(Call<CountriesResponse> call, Response<CountriesResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<Countries> countries = response.body().getCountries();
                            CountriesAdapter adapter = new CountriesAdapter(MainActivity3.this, countries);
                            recyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<CountriesResponse> call, Throwable t) {
                        Toast.makeText(MainActivity3.this, "Gagal load data", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}