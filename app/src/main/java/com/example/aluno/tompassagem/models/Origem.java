package com.example.aluno.tompassagem.models;

/**
 * Created by aluno on 22/06/2018.
 */

public class Origem {

    private String cidade, aeroporto, id, dataVoo;

    public Origem() {
    }

    public Origem(String cidade, String aeroporto, String id) {
        this.cidade = cidade;
        this.aeroporto = aeroporto;
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(String aeroporto) {
        this.aeroporto = aeroporto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
