package com.example.apirecycler;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;
import java.util.List;

public class APIrecycler extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_recycler);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadTeams();
    }

    private void loadTeams() {
        APIClient.getApiClient().getTeams("English Premier League")
                .enqueue(new Callback<TeamResponse>() {
                    @Override
                    public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<Team> teams = response.body().getTeams();
                            TeamAdapter adapter = new TeamAdapter(APIrecycler.this, teams);
                            recyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<TeamResponse> call, Throwable t) {
                        Toast.makeText(APIrecycler.this, "Gagal load data", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
