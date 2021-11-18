package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private Button buttonMentes;
    private EditText editTextNev;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        buttonMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextNev.getText().toString().equals("")) {
                    Toast.makeText(MainActivity2.this, "Nincs beírva név!", Toast.LENGTH_SHORT).show();
                }else {
                    //belehelyeztünk az értéket a Data.xml-be
                    //String nev: {nev}
                    editor.putString("nev", editTextNev.getText().toString());
                    //végegesítes
                    //commit ->visszaad egy booleant true ha sikeres, false ha nem
                    editor.commit();
                    //apply -> nem ad vissza semmit
                    editor.apply();
                    Toast.makeText(MainActivity2.this, "Sikeres mentés!", Toast.LENGTH_SHORT).show();

                    //vissza az előző activityre
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void init(){
        buttonMentes = findViewById(R.id.button_mentes);
        editTextNev = findViewById(R.id.edit_txt_nev);
        sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
}