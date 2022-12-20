package com.example.atividadesavaliativas;
import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button bt_dw,bt_ihc;
    FirebaseFirestore db;
    String questao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        bt_dw = findViewById(R.id.bt_dw);
        bt_ihc = findViewById(R.id.bt_idh);

        db.collection("DesenvolvimentoWeb").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });


        bt_dw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DesenvolvimentoWeb.class);
                startActivity(i);
            }
        });
        bt_ihc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ""+questao, Toast.LENGTH_SHORT).show();
            }
        });

    }


}