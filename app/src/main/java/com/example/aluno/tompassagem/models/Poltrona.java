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
                Poltrona voo = new Poltrona();
                if(obj.has("assento")) {
                    voo.setAssento(obj.getString("assento"));
                    voo.setId(obj.getString("assento"));
                }
                if(obj.has("ocupado"))
                    voo.setOcupado(obj.getBoolean("ocupado"));

                lista.add(voo);
            }
        }

        return lista;
    }
}
