package com.example.atividadesavaliativas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DwFim extends AppCompatActivity {

    int Placar, Questao;
    TextView acertos,total;
    String mensagem1 = "de ";
    String mensagem2 = " questões";
    Button sair, reiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dw_fim);
        acertos = findViewById(R.id.acertos);
        total = findViewById(R.id.total_questoes);
        sair = findViewById(R.id.bt_sair);
        reiniciar = findViewById(R.id.bt_reiniciar);


        Intent intent = getIntent();
        if(intent != null) {
            Placar = intent.getIntExtra("placar", 0);
            Questao = intent.getIntExtra("questaoEscolhida", 0);

        }
        String placar = String.valueOf(Placar);
        String mensagem = mensagem1+placar+mensagem2;
        acertos.setText(String.valueOf(Placar));
        total.setText(mensagem);
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();

            }

        });
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(DwFim.this,MainActivity.class);
                startActivity(i);

            }
        });


    }
}