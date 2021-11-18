package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonNev, buttonInformacio

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonNev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Egyik odaról a másikra váltás => Intent
            }
        });
    }

    private void init(){
        buttonNev = findViewById(R.id.button_nev);
        buttonInformacio = findViewById(R.id.button_informacio);
    }
}