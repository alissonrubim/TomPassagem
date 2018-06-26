package com.example.aluno.tompassagem.models;

import com.example.aluno.tompassagem.api.ApiModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aluno on 25/06/2018.
 */

public class Cartao implements ApiModel {

    String numero, validade, tarja, bandeira, status, valor;

    public Cartao() {
    }

    public Cartao(String numero, String validade, String tarja, String bandeira, String status, String valor) {
        this.numero = numero;
        this.validade = validade;
        this.tarja = tarja;
        this.bandeira = bandeira;
        this.status = status;
        this.valor = valor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toJSON() {
        JSONObject jsonObject= new JSONObject();
        try {
            jsonObject.put("numero", getNumero());
            jsonObject.put("validade", getValidade());
            jsonObject.put("tarja", getTarja());
            jsonObject.put("bandeira", getBandeira());
            jsonObject.put("status", getStatus());
            jsonObject.put("valor", getValor());

            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void applyJSON(String json) {
        Cartao result = null;
        try {
            JSONObject object = new JSONObject(json);
            if(object.has("id"))
                this.setNumero(object.getString("numero"));
            if(object.has("token"))
                this.setValidade(object.getString("validade"));
            if(object.has("login"))
                this.setTarja(object.getString("tarja"));
            if(object.has("nome"))
                this.setBandeira(object.getString("bandeira"));
            if(object.has("email"))
                this.setStatus(object.getString("status"));
            if(object.has("senha"))
                this.setValor(object.getString("valor"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
