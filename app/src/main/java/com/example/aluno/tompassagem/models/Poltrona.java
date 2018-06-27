package com.example.aluno.tompassagem.models;

import com.example.aluno.tompassagem.api.ApiModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by aluno on 22/06/2018.
 */

public class Poltrona implements ApiModel {

    String assento,origem, destino, dataVoo , valorPassagem ,aviao;
    Boolean ocupado;

    public Poltrona() {
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataVoo() {
        return dataVoo;
    }

    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }

    public String getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(String valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    public String getAviao() {
        return aviao;
    }

    public void setAviao(String aviao) {
        this.aviao = aviao;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toJSON() {
        return null;
    }

    @Override
    public void applyJSON(String json) {

    }

    public static ArrayList<Poltrona> JSONtoList(String JSONresult) throws JSONException {
        ArrayList<Poltrona> lista = new ArrayList<>();


            if(!JSONresult.isEmpty()) {
            JSONArray json = new JSONArray(JSONresult);
            for(int i=0; i<json.length(); i++){
                JSONObject obj = json.getJSONObject(i);
                Poltrona poltrona = new Poltrona();
                if(obj.has("assento"))
                    poltrona.setAssento(obj.getString("assento"));
                if(obj.has("origem"))
                    poltrona.setOrigem(obj.getString("origem"));
                if(obj.has("destino"))
                    poltrona.setDestino(obj.getString("destino"));
                if(obj.has("dataVoo"))
                    poltrona.setDataVoo(obj.getString("dataVoo"));
                if(obj.has("valorPassagem"))
                    poltrona.setValorPassagem(obj.getString("valorPassagem"));
                if(obj.has("aviao"))
                    poltrona.setAviao(obj.getString("aviao"));
                if(obj.has("ocupado"))
                    poltrona.setOcupado(obj.getBoolean("ocupado"));

                lista.add(poltrona);
            }
        }

        return lista;
    }
}


