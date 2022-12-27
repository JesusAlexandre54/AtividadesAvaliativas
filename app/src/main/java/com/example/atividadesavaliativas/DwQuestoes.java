package com.example.atividadesavaliativas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class DwQuestoes extends AppCompatActivity {
    RadioButton a,b,c,d,e;
    Button bt_resposta, bt_continuar;
    RadioGroup radioGroup;
    TextView tv_resposta, tv_placar,tv_questao,numeroQuestao;
    String questao, resp1,resp2,resp3,resp4,resp5,respcorreta;
    //Firestore
    FirebaseFirestore db;
    int Placar ;
    int Questao ;
    String resposta="";



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dw_questoes);
        Objects.requireNonNull(getSupportActionBar()).hide();
        db = FirebaseFirestore.getInstance();
        bt_resposta = findViewById(R.id.bt_resp);
        bt_continuar = findViewById(R.id.bt_continuar);
        radioGroup = findViewById(R.id.rd_Group);
        tv_resposta = findViewById(R.id.tv_resp);
        tv_placar = findViewById(R.id.placar);
        tv_questao =findViewById(R.id.tv_questao);
        a = findViewById(R.id.dw_a);
        b = findViewById(R.id.dw_b);
        c = findViewById(R.id.dw_c);
        d = findViewById(R.id.dw_d);
        e = findViewById(R.id.dw_e);

        Intent intent = getIntent();
        if(intent != null) {
            Placar = intent.getIntExtra("placar", 0);
            Questao = intent.getIntExtra("questaoEscolhida", 0);
            }else {
            Placar = 0;
            Questao = 1;
        }

        tv_placar = findViewById(R.id.placar);
        tv_placar.setText(String.valueOf(Placar));


        numeroQuestao = findViewById(R.id.n_questao);
        numeroQuestao.setText(String.valueOf(Questao));


        String questao_aleatoria =String.valueOf(Questao);

              db.collection("DesenvolvimentoWeb").document(questao_aleatoria)
               .addSnapshotListener((documento, error) -> {
                   if (documento!=null){
                       questao = documento.getString("questao");
                       resp1 = documento.getString("resp1");
                       resp2 = documento.getString("resp2");
                       resp3 = documento.getString("resp3");
                       resp4 = documento.getString("resp4");
                       resp5 = documento.getString("resp5");
                       respcorreta = documento.getString("respcorreta");

                       tv_questao.setText(questao);
                       a.setText(resp1);
                       b.setText(resp2);
                       c.setText(resp3);
                       d.setText(resp4);
                       e.setText(resp5);

                   }
               });
        bt_resposta.setOnClickListener(view -> {


                if (!(a.isChecked()||b.isChecked()||c.isChecked()||d.isChecked()||e.isChecked())){
                Toast.makeText(DwQuestoes.this, "É necessario selecionar uma ersposta!", Toast.LENGTH_SHORT).show();
                return;
               }else{

               if (a.isChecked() && resp1.equals(respcorreta)) {
                    resposta = "Acertou !";
                    Placar += 1;
                   a.setEnabled(false);
                   a.setTextColor(Color.parseColor("#006400"));
                   a.setText(resp1 + " RESPOSTA CORRETA!");
                   b.setEnabled(false);
                   c.setEnabled(false);
                   d.setEnabled(false);
                   e.setEnabled(false);


                }else if (b.isChecked() && resp2.equals(respcorreta)) {
                    resposta = "Acertou !";
                    Placar += 1;
                   b.setEnabled(false);
                   b.setTextColor(Color.parseColor("#006400"));
                   b.setText(resp2 + " RESPOSTA CORRETA!");
                   a.setEnabled(false);
                   c.setEnabled(false);
                   d.setEnabled(false);
                   e.setEnabled(false);

                }else if (c.isChecked() && resp3.equals(respcorreta)) {
                    resposta = "Acertou !";
                    Placar += 1;
                   c.setEnabled(false);
                   c.setTextColor(Color.parseColor("#006400"));
                   c.setText(resp3 + " RESPOSTA CORRETA!");
                   a.setEnabled(false);
                   b.setEnabled(false);
                   d.setEnabled(false);
                   e.setEnabled(false);

                }else if (d.isChecked() && resp4.equals(respcorreta)) {
                    resposta = "Acertou !";
                    Placar += 1;
                   d.setEnabled(false);
                   d.setTextColor(Color.parseColor("#006400"));
                   d.setText(resp4 + " RESPOSTA CORRETA!");
                   a.setEnabled(false);
                   b.setEnabled(false);
                   c.setEnabled(false);
                   e.setEnabled(false);

                }else if (e.isChecked() && resp5.equals(respcorreta)) {
                    resposta = "Acertou !";
                    Placar += 1;
                   e.setEnabled(false);
                   e.setTextColor(Color.parseColor("#006400"));
                   e.setText(resp5+ " RESPOSTA CORRETA!");
                   a.setEnabled(false);
                   c.setEnabled(false);
                   b.setEnabled(false);
                   d.setEnabled(false);

                }else if (!(resposta.equals("Acertou !"))){

                    resposta = "Errou !"; }
                }
            if (resp1.equals(respcorreta)){
                if (b.isChecked()){
                a.setEnabled(false);
                a.setTextColor(Color.parseColor("#006400"));
                a.setText(resp1 + " RESPOSTA CORRETA!");
                b.setEnabled(false);
                //b.setTextColor(Color.parseColor("#636161"));
                c.setEnabled(false);
                d.setEnabled(false);
                e.setEnabled(false);
                }else if (c.isChecked()){
                    a.setEnabled(false);
                    a.setTextColor(Color.parseColor("#006400"));
                    a.setText(resp1 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    c.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (d.isChecked()){
                    a.setEnabled(false);
                    a.setTextColor(Color.parseColor("#006400"));
                    a.setText(resp1 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //d.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (e.isChecked()){
                    a.setEnabled(false);
                    a.setTextColor(Color.parseColor("#006400"));
                    a.setText(resp1 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //e.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);}
            }
            if (resp2.equals(respcorreta)){
                if (a.isChecked()){
                    a.setEnabled(false);
                    b.setTextColor(Color.parseColor("#006400"));
                    b.setText(resp2 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //a.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (c.isChecked()){
                    a.setEnabled(false);
                    b.setTextColor(Color.parseColor("#006400"));
                    b.setText(resp2 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //c.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (d.isChecked()){
                    a.setEnabled(false);
                    b.setTextColor(Color.parseColor("#006400"));
                    b.setText(resp2 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //d.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (e.isChecked()){
                    a.setEnabled(false);
                    b.setTextColor(Color.parseColor("#006400"));
                    b.setText(resp2 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //e.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);}
            }
            if (resp3.equals(respcorreta)){
                if (b.isChecked()){
                    a.setEnabled(false);
                    c.setTextColor(Color.parseColor("#006400"));
                    c.setText(resp3 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //b.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (c.isChecked()){
                    a.setEnabled(false);
                    c.setTextColor(Color.parseColor("#006400"));
                    c.setText(resp3 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //c.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (d.isChecked()){
                    a.setEnabled(false);
                    c.setTextColor(Color.parseColor("#006400"));
                    c.setText(resp3 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //d.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (e.isChecked()){
                    a.setEnabled(false);
                    c.setTextColor(Color.parseColor("#006400"));
                    c.setText(resp3 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //e.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);}
            }
            if (resp4.equals(respcorreta)){
                if (b.isChecked()){
                    a.setEnabled(false);
                    d.setTextColor(Color.parseColor("#006400"));
                    d.setText(resp4 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //b.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (c.isChecked()){
                    a.setEnabled(false);
                    d.setTextColor(Color.parseColor("#006400"));
                    d.setText(resp4 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //c.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (d.isChecked()){
                    a.setEnabled(false);
                    d.setTextColor(Color.parseColor("#006400"));
                    d.setText(resp4 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //d.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (e.isChecked()){
                    a.setEnabled(false);
                    d.setTextColor(Color.parseColor("#006400"));
                    d.setText(resp4 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //e.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);}
            }
            if (resp5.equals(respcorreta)){
                if (b.isChecked()){
                    a.setEnabled(false);
                    e.setTextColor(Color.parseColor("#006400"));
                    e.setText(resp5 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //b.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (c.isChecked()){
                    a.setEnabled(false);
                    e.setTextColor(Color.parseColor("#006400"));
                    e.setText(resp5 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //c.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (d.isChecked()){
                    a.setEnabled(false);
                    e.setTextColor(Color.parseColor("#006400"));
                    e.setText(resp5 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //d.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);
                }else if (e.isChecked()){
                    a.setEnabled(false);
                    e.setTextColor(Color.parseColor("#006400"));
                    e.setText(resp5 + " RESPOSTA CORRETA!");
                    b.setEnabled(false);
                    //e.setTextColor(Color.parseColor("#006400"));
                    c.setEnabled(false);
                    d.setEnabled(false);
                    e.setEnabled(false);}
            }


            //Toast.makeText(DwQuestao1.this, "Selecionado"+resposta, Toast.LENGTH_SHORT).show();
            String placar = Integer.toString(Placar);
            tv_placar.setText(placar);
            tv_resposta.setText(resposta); });
        bt_continuar.setOnClickListener(view -> {

            if (!(a.isChecked()||b.isChecked()||c.isChecked()||d.isChecked()||e.isChecked())){
                Toast.makeText(DwQuestoes.this, "É necessario selecionar uma ersposta!", Toast.LENGTH_SHORT).show();

            } else if ( resposta.equals("")){

                Toast.makeText(DwQuestoes.this, "É necessario uma responder antes de continuar!", Toast.LENGTH_SHORT).show();

            }else{
            Questao+=1;


            Intent i = new Intent(DwQuestoes.this,DesenvolvimentoWeb.class);
            i.putExtra("placar",Placar);
            i.putExtra("questaoEscolhida",Questao);


            startActivity(i);}
        });





    }
}