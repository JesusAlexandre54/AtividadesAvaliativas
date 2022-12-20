package com.example.atividadesavaliativas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class DesenvolvimentoWeb extends AppCompatActivity {
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desenvolvimento_web);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                i = new Intent(DesenvolvimentoWeb.this, DwQuestoes.class);

                startActivity(i);

            }
        }, 4000);
    }
}