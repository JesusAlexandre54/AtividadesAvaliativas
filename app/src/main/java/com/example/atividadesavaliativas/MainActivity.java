package com.example.atividadesavaliativas;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.atividadesavaliativas.DesenvolvimentoWeb.DesenvolvimentoWeb;
import com.example.atividadesavaliativas.EstrututuraDeDados.EstruturaDeDados;
import com.example.atividadesavaliativas.FundamentosInternetWeb.FundamentosInternetWeb;
import com.example.atividadesavaliativas.PensamentoComputacional.PensamentoComputacional;
import com.example.atividadesavaliativas.ProjetoseMetodosParaProducao.ProjetoseMetodosParaProducao;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    Button bt_dw,bt_fiw,bt_pcomp,bt_projemetodos,bt_estrutura;
    FirebaseFirestore db;
    String questao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        bt_estrutura = findViewById(R.id.bt_estrutura_de_dados);
        bt_dw = findViewById(R.id.bt_dw);
        bt_fiw = findViewById(R.id.bt_fiw);
        bt_pcomp = findViewById(R.id.bt_pensamento_computacional);
        bt_projemetodos = findViewById(R.id.bt_projetos_e_metodos);


        db.collection("DesenvolvimentoWeb").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });
        db.collection("FundamentosInternetWeb").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });
        db.collection("PensamentoComputacional").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });
        db.collection("PensamentoComputacional").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });
        db.collection("EstruturaDeDados").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });


        bt_dw.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, DesenvolvimentoWeb.class);
            startActivity(i);
        });
        bt_fiw.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, FundamentosInternetWeb.class);
            startActivity(i);

        });
        bt_pcomp.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, PensamentoComputacional.class);
            startActivity(i);

        });
        bt_projemetodos.setOnClickListener(view ->{
            Intent i = new Intent(MainActivity.this, ProjetoseMetodosParaProducao.class);
            startActivity(i);
        });
        bt_estrutura.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, EstruturaDeDados.class);
            startActivity(i);

        });

    }


}