package com.example.aluno.tompassagem.models;

/**
 * Created by aluno on 22/06/2018.
 */

public class Aviao {
    private String id, capacidade, modelo, prefixo;

    public Aviao() {
    }

    public Aviao(String id, String capacidade, String modelo, String prefixo) {
        this.id = id;
        this.capacidade = capacidade;
        this.modelo = modelo;
        this.prefixo = prefixo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
}
