package com.example.apirecycler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    Button btnPremierLeague, btnSpanishLeague, btnAllCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        btnPremierLeague = (Button) findViewById(R.id.buttonPremiereLeague);
        btnSpanishLeague = (Button) findViewById(R.id.buttonSpanishLeague);
        btnAllCountries = (Button) findViewById(R.id.buttonAllCountries);

        btnPremierLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnSpanishLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });

        btnAllCountries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });
    }
}