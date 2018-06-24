package com.example.aluno.tompassagem.models;

/**
 * Created by aluno on 22/06/2018.
 */

public class Poltrona {

    private String id, assento;
    private Boolean ocupado;
    private Usuario usur;

    public Poltrona() {
    }

    public Poltrona(String id, String assento, Boolean ocupado, Usuario usur) {
        this.id = id;
        this.assento = assento;
        this.ocupado = ocupado;
        this.usur = usur;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Usuario getUsur() {
        return usur;
    }

    public void setUsur(Usuario usur) {
        this.usur = usur;
    }
}
