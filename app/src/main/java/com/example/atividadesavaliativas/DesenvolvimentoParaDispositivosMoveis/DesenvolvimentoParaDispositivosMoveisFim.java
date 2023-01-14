package com.example.atividadesavaliativas.DesenvolvimentoParaDispositivosMoveis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.atividadesavaliativas.MainActivity;
import com.example.atividadesavaliativas.R;

public class DesenvolvimentoParaDispositivosMoveisFim extends AppCompatActivity {

    int Placar, Questao;
    TextView acertos, total,voceacertou;
    String mensagem1 = "de ";
    String mensagem2 = " questões";
    Button sair, reiniciar;
    ImageView imagemFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desenvolvimento_para_dispositivos_moveis_fim);

        acertos = findViewById(R.id.acertos);
        total = findViewById(R.id.total_questoes);
        sair = findViewById(R.id.bt_sair);
        reiniciar = findViewById(R.id.bt_reiniciar);
        imagemFinal = findViewById(R.id.imagemFinal);
        voceacertou =findViewById(R.id.voceacertou);


        Intent intent = getIntent();
        if (intent != null) {
            Placar = intent.getIntExtra("placar", 0);
            Questao = intent.getIntExtra("questaoEscolhida", 0);

        }
        String quant_questao = String.valueOf(Questao);
        String mensagem = mensagem1 + quant_questao + mensagem2;
        if (Questao == 0){
            imagemFinal.setVisibility(View.VISIBLE);
            acertos.setVisibility(View.GONE);
            total.setVisibility(View.GONE);
            voceacertou.setVisibility(View.GONE);
        }else {
            acertos.setText(String.valueOf(Placar));
            total.setText(mensagem);
            imagemFinal.setVisibility(View.GONE);

        }
        sair.setOnClickListener(view -> finishAffinity());
        reiniciar.setOnClickListener(view -> {

            Intent i = new Intent(DesenvolvimentoParaDispositivosMoveisFim.this, MainActivity.class);
            startActivity(i);

        });


    }
}