package com.example.atividadesavaliativas.PensamentoComputacional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.atividadesavaliativas.DesenvolvimentoWeb.DwFim;
import com.example.atividadesavaliativas.MainActivity;
import com.example.atividadesavaliativas.R;

public class PcompFim extends AppCompatActivity {
    int Placar, Questao;
    TextView acertos,total;
    String mensagem1 = "de ";
    String mensagem2 = " questões";
    Button sair, reiniciar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcomp_fim);
        acertos = findViewById(R.id.acertos);
        total = findViewById(R.id.total_questoes);
        sair = findViewById(R.id.bt_sair);
        reiniciar = findViewById(R.id.bt_reiniciar);


        Intent intent = getIntent();
        if(intent != null) {
            Placar = intent.getIntExtra("placar", 0);
            Questao = intent.getIntExtra("questaoEscolhida", 0);

        }
        String quant_questao = String.valueOf(Questao);
        String mensagem = mensagem1+quant_questao+mensagem2;
        acertos.setText(String.valueOf(Placar));
        total.setText(mensagem);
        sair.setOnClickListener(view -> finishAffinity());
        reiniciar.setOnClickListener(view -> {

            Intent i = new Intent(PcompFim.this, MainActivity.class);
            startActivity(i);

        });

    }
}