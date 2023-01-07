package com.example.atividadesavaliativas;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.atividadesavaliativas.DesenvolvimentoWeb.DesenvolvimentoWeb;
import com.example.atividadesavaliativas.FundamentosInternetWeb.FundamentosInternetWeb;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    Button bt_dw,bt_fiw;
    FirebaseFirestore db;
    String questao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        bt_dw = findViewById(R.id.bt_dw);
        bt_fiw = findViewById(R.id.bt_fiw);


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


        bt_dw.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, DesenvolvimentoWeb.class);
            startActivity(i);
        });
        bt_fiw.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, FundamentosInternetWeb.class);
            startActivity(i);

        });

    }


}