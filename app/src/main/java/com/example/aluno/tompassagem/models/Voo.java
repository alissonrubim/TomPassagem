package com.example.aluno.tompassagem.models;

/**
 * Created by aluno on 22/06/2018.
 */

public class Voo {
    String id, valorPass, data;
    Origem origem;
    Destino destino;

    public Voo() {
    }

    public Voo(String id, String valorPass, String data, Origem origem, Destino destino) {
        this.id = id;
        this.valorPass = valorPass;
        this.data = data;
        this.origem = origem;
        this.destino = destino;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValorPass() {
        return valorPass;
    }

    public void setValorPass(String valorPass) {
        this.valorPass = valorPass;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }
}
