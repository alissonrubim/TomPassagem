package com.example.aluno.tompassagem.models;

import com.example.aluno.tompassagem.api.ApiModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by aluno on 22/06/2018.
 */

public class Voo implements ApiModel {
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

    @Override
    public String toJSON() {
        return null;
    }

    @Override
    public void applyJSON(String json) {

    }

    public static ArrayList<Voo> JSONtoList(String JSONresult) throws JSONException {
        ArrayList<Voo> lista = new ArrayList<>();

        if(!JSONresult.isEmpty()) {
            JSONArray json = new JSONArray(JSONresult);
            for(int i=0; i<json.length(); i++){
                JSONObject voo = json.getJSONObject(i);
                Voo vooobj = new Voo();
                lista.add(vooobj);
            }
        }

        return lista;
    }
}
