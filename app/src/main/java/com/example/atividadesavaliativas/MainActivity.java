package com.example.atividadesavaliativas;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.atividadesavaliativas.BancoDeDados.BancoDeDados;
import com.example.atividadesavaliativas.Compiladores.Compiladores;
import com.example.atividadesavaliativas.DesenvolvimentoParaDispositivosMoveis.DesenvolvimentoParaDispositivosMoveis;
import com.example.atividadesavaliativas.DesenvolvimentoWeb.DesenvolvimentoWeb;
import com.example.atividadesavaliativas.EngenhariaDeSoftware.EngenhariaDeSoftware;
import com.example.atividadesavaliativas.EstrututuraDeDados.EstruturaDeDados;
import com.example.atividadesavaliativas.FormacaoProfissionalEmComputacao.FormacaoProfissionalEmComputacao;
import com.example.atividadesavaliativas.FundamentosInternetWeb.FundamentosInternetWeb;
import com.example.atividadesavaliativas.GestaoDaInovacaoeDesenvolvimentoDeProdutos.GestaoDaInovacaoeDesenvolvimentoDeProdutos;
import com.example.atividadesavaliativas.ImpactosDaComputacaoNaSociedade.ImpactosDaComputacaoNaSociedade;
import com.example.atividadesavaliativas.InfraestruturaParaSistemasDeSoftware.InfraestruturaParaSistemasDeSoftware;
import com.example.atividadesavaliativas.InterfaceHumanoComputador.InterfaceHumanoComputador;
import com.example.atividadesavaliativas.IntroducaoeConceitosdeComputacao.IntroducaoeConceitoDeComputacao;
import com.example.atividadesavaliativas.PensamentoComputacional.PensamentoComputacional;
import com.example.atividadesavaliativas.ProcessamentoDigitalDeSinais.ProcessamentoDigitalDeSinais;
import com.example.atividadesavaliativas.ProgramacaoOrientadaaObjetos.ProgramacaoOrientadaaObjetos;
import com.example.atividadesavaliativas.ProjetoseMetodosParaProducao.ProjetoseMetodosParaProducao;
import com.example.atividadesavaliativas.ProtocolosDeComunicacaoIot.ProtocolosDeComunicacaoIot;
import com.example.atividadesavaliativas.SistemasComputacionais.SistemasComputacionais;
import com.example.atividadesavaliativas.SistemasEmbarcados.SistemasEmbarcados;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    Button bt_dw,bt_fiw,bt_pcomp,bt_projemetodos,bt_estrutura,bt_introducao,
            bt_sistemasComputacionais,bt_poo,bt_desenvolvimentoParaAplicativosMoveis,bt_bancodedados,
             bt_compiladores, bt_engenhariaDeSoftware, bt_formacaoProfissional, bt_gestaodaInovacao,
            bt_impactos, bt_infraEstrutura, bt_interfaceHumanoComp,bt_processamentoDig,bt_protocoloComIot,
    bt_sistemasEmbarcados;
    FirebaseFirestore db;
    String questao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        bt_sistemasEmbarcados=findViewById(R.id.bt_sistemas_embarcados);
        bt_protocoloComIot = findViewById(R.id.bt_protocolos_de_comunicação_iot);
        bt_processamentoDig = findViewById(R.id.bt_processamento_digital_de_sinais);
        bt_interfaceHumanoComp = findViewById(R.id.bt_interface_humano_computador);
        bt_infraEstrutura = findViewById(R.id.bt_infraestrutura_para_sistemas_de_software);
        bt_impactos = findViewById(R.id.bt_impactos_da_computacao_na_sociedade);
        bt_gestaodaInovacao =findViewById(R.id.bt_gestão_da_Inovação_e_Desenvolvimento_de_Produtos);
        bt_formacaoProfissional = findViewById(R.id.bt_formacao_profissional_em_computacao);
        bt_engenhariaDeSoftware = findViewById(R.id.bt_engenharia_de_software);
        bt_compiladores = findViewById(R.id.bt_compiladores);
        bt_bancodedados =findViewById(R.id.bt_banco_de_dados);
        bt_desenvolvimentoParaAplicativosMoveis = findViewById(R.id.bt_desenvolvimento_para_dispositivos_moveis);
        bt_poo=findViewById(R.id.bt_programacao_orientada_a_objetos);
        bt_sistemasComputacionais = findViewById(R.id.bt_sistemas_computacionais);
        bt_introducao = findViewById(R.id.bt_introducao_e_conceitos_de_computacao);
        bt_estrutura = findViewById(R.id.bt_estrutura_de_dados);
        bt_dw = findViewById(R.id.bt_dw);
        bt_fiw = findViewById(R.id.bt_fiw);
        bt_pcomp = findViewById(R.id.bt_pensamento_computacional);
        bt_projemetodos = findViewById(R.id.bt_projetos_e_metodos);
        db.collection("SistemasEmbarcados").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }
                });
        db.collection("ProtocolosDeComunicacaoIot").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }
                });
        db.collection("ProcessamentoDigitalDeSinais").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }
                });
        db.collection("InterfaceHumanoComputador").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }
                });
        db.collection("InfraestruturaParaSistemasDeSoftware").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }
                });
        db.collection("ImpactosDaComputacaoNaSociedade").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }
                });
        db.collection("GestaoDaInovacaoDeProdutos").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }
                });
        db.collection("FormacaoProfissionalEmComputacao").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }
                });
        db.collection("EngenhariaDeSoftware").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }
                });
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
        db.collection("ProjetoseMetodosParaProducao").document("1")
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
        db.collection("IntroducaoeConceitosDeComputacao").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });
        db.collection("SistemasComputacionais").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });
        db.collection("ProgramacaoOrientadaaObjetos").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });
        db.collection("DesenvolvimentoParaDispositivosMoveis").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });
        db.collection("BancoDeDados").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });
        db.collection("Compiladores").document("1")
                .addSnapshotListener((documento, error) -> {
                    if (documento!=null){
                        questao = documento.getString("questao");
                    }

                });

        bt_pcomp.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, PensamentoComputacional.class);
            startActivity(i);

        });
        bt_impactos.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, ImpactosDaComputacaoNaSociedade.class);
            startActivity(i);
        });
        bt_projemetodos.setOnClickListener(view ->{
            Intent i = new Intent(MainActivity.this, ProjetoseMetodosParaProducao.class);
            startActivity(i);
        });
        bt_introducao.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, IntroducaoeConceitoDeComputacao.class);
            startActivity(i);
        });
        bt_fiw.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, FundamentosInternetWeb.class);
            startActivity(i);

        });
        bt_estrutura.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, EstruturaDeDados.class);
            startActivity(i);

        });
        bt_formacaoProfissional.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, FormacaoProfissionalEmComputacao.class);
            startActivity(i);
        });
        bt_gestaodaInovacao.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, GestaoDaInovacaoeDesenvolvimentoDeProdutos.class);
            startActivity(i);
        });
        bt_poo.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, ProgramacaoOrientadaaObjetos.class);
            startActivity(i);
        });
        bt_sistemasComputacionais.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, SistemasComputacionais.class);
            startActivity(i);
        });
        bt_bancodedados.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, BancoDeDados.class);
            startActivity(i);
        });
        bt_engenhariaDeSoftware.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, EngenhariaDeSoftware.class);
            startActivity(i);
        });
        bt_protocoloComIot.setOnClickListener(view ->
            startActivity(new Intent(MainActivity.this, ProtocolosDeComunicacaoIot.class)));

        bt_compiladores.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, Compiladores.class);
            startActivity(i);
        });
        bt_impactos.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, ImpactosDaComputacaoNaSociedade.class);
          startActivity(i);
        });

        bt_dw.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, DesenvolvimentoWeb.class);
            startActivity(i);
        });
        bt_infraEstrutura.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, InfraestruturaParaSistemasDeSoftware.class);
            startActivity(i);
        });
        bt_interfaceHumanoComp.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, InterfaceHumanoComputador.class)));
       bt_desenvolvimentoParaAplicativosMoveis.setOnClickListener(view -> {
           Intent i = new Intent(MainActivity.this, DesenvolvimentoParaDispositivosMoveis.class);
           startActivity(i);       });
       bt_processamentoDig.setOnClickListener(view ->
               startActivity(new Intent(MainActivity.this, ProcessamentoDigitalDeSinais.class)));
       bt_sistemasEmbarcados.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SistemasEmbarcados.class)));
    }


}