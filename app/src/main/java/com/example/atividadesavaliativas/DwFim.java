package com.example.atividadesavaliativas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DwFim extends AppCompatActivity {

    int Placar, Questao;
    TextView acertos,total;
    String mensagem1 = "de ";
    String mensagem2 = " questões";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dw_fim);
        acertos = findViewById(R.id.acertos);
        total = findViewById(R.id.total_questoes);


        Intent intent = getIntent();
        if(intent != null) {
            Placar = intent.getIntExtra("placar", 0);
            Questao = intent.getIntExtra("questaoEscolhida", 0);

        }
        String mensagem = mensagem1+String.valueOf(Placar)+mensagem2;
        acertos.setText(String.valueOf(Placar));
        total.setText(mensagem);


    }
}