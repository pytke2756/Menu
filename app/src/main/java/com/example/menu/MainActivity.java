package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonNev, buttonInformacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonNev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Egyik odaról a másikra váltás => Intent
                //honnan hova
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                //backStack
                finish();
            }
        });

        buttonInformacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //globális vátozó
                SharedPreferences sharedPreferences = getSharedPreferences("Data",
                        Context.MODE_PRIVATE);
                String seged = sharedPreferences.getString("nev","Nincs elmentve név!");
                Toast.makeText(MainActivity.this, seged, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init(){
        buttonNev = findViewById(R.id.button_nev);
        buttonInformacio = findViewById(R.id.button_informacio);
    }
}