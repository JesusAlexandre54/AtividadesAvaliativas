package com.example.atividadesavaliativas;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.Objects;

public class DesenvolvimentoWeb extends AppCompatActivity {
    Intent i;
    int Placar, Questao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desenvolvimento_web);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Intent intent = getIntent();
        if(intent != null) {
            Placar = intent.getIntExtra("placar", 0);
            Questao = intent.getIntExtra("questaoEscolhida",1);

        }else {
            Placar = 0;
        }

        new Handler().postDelayed(() -> {
            if (Questao > 3){
                i = new Intent(DesenvolvimentoWeb.this, DwFim.class);
                i.putExtra("placar", Placar);
                startActivity(i);

            }else {
                i = new Intent(DesenvolvimentoWeb.this, DwQuestoes.class);
                i.putExtra("placar", Placar);
                i.putExtra("questaoEscolhida", Questao);

                startActivity(i);
            }
        }, 3000);
    }
}