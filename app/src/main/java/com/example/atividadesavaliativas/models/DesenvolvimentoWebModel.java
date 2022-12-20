package com.example.atividadesavaliativas.models;

import java.io.Serializable;

public class DesenvolvimentoWebModel implements Serializable {
    String Questao, Resposta1,Resposta2,Resposta3,Resposta4,Resposta5,RespostaCorreta;

    public DesenvolvimentoWebModel() {
    }

    public DesenvolvimentoWebModel(String Questao, String Resposta1, String Resposta2, String Resposta3, String Resposta4, String Resposta5, String RespostaCorreta) {
        Questao   = Questao;
        Resposta1 = Resposta1;
        Resposta2 = Resposta2;
        Resposta3 = Resposta3;
        Resposta4 = Resposta4;
        Resposta5 = Resposta5;
        RespostaCorreta = RespostaCorreta;
    }

    public String getQuestao() {
        return Questao;
    }

    public void setQuestao(String Questao) {
        Questao = Questao;
    }

    public String getResposta1() {
        return Resposta1;
    }

    public void setResposta1(String Resposta1) {
        Resposta1 = Resposta1;
    }

    public String getResposta2() {
        return Resposta2;
    }

    public void setResposta2(String Resposta2) {
        Resposta2 = Resposta2;
    }

    public String getResposta3() {
        return Resposta3;
    }

    public void setResposta3(String Resposta3) {
        Resposta3 = Resposta3;
    }

    public String getResposta4() {
        return Resposta4;
    }

    public void setResposta4(String Resposta4) {
        Resposta4 = Resposta4;
    }

    public String getResposta5() {
        return Resposta5;
    }

    public void setResposta5(String Resposta5) {
        Resposta5 = Resposta5;
    }

    public String getRespostaCorreta() {
        return RespostaCorreta;
    }

    public void setRespostaCorreta(String RespostaCorreta) {
        RespostaCorreta = RespostaCorreta;
    }
}
