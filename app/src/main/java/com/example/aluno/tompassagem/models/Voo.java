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

    public String id, valorPass, data;
    public Origem origem;
    public Destino destino;

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Aviao aviao;

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
                JSONObject obj = json.getJSONObject(i);
                Voo voo = new Voo();
                if(obj.has("id"))
                    voo.setId(obj.getString("id"));
                if(obj.has("origem")){
                    JSONObject objOrigem = obj.getJSONObject("origem");
                    Origem origem = new Origem();
                    if(objOrigem.has("id"))
                        origem.setId(objOrigem.getString("id"));

                    if(objOrigem.has("aeroporto"))
                        origem.setAeroporto(objOrigem.getString("aeroporto"));

                    if(objOrigem.has("cidade"))
                        origem.setCidade(objOrigem.getString("cidade"));

                    voo.setOrigem(origem);
                }

                if(obj.has("destino")){
                    JSONObject objDestino = obj.getJSONObject("destino");
                    Destino destino = new Destino();
                    if(objDestino.has("id"))
                        destino.setId(objDestino.getString("id"));

                    if(objDestino.has("aeroporto"))
                        destino.setAeroporto(objDestino.getString("aeroporto"));

                    if(objDestino.has("cidade"))
                        destino.setCidade(objDestino.getString("cidade"));

                    voo.setDestino(destino);
                }

                if(obj.has("dataVoo")) {
                    voo.setData(obj.getString("dataVoo"));
                }

                if(obj.has("valorPassagem")) {
                    voo.setValorPass(obj.getString("valorPassagem"));
                }

                if(obj.has("aviao")) {
                    JSONObject objOrigem = obj.getJSONObject("aviao");
                    Aviao origem = new Aviao();
                    if(objOrigem.has("id"))
                        origem.setId(objOrigem.getString("id"));

                    if(objOrigem.has("prefixo"))
                        origem.setPrefixo(objOrigem.getString("prefixo"));

                    if(objOrigem.has("modelo"))
                        origem.setModelo(objOrigem.getString("modelo"));


                    if(objOrigem.has("capacidade"))
                        origem.setCapacidade(objOrigem.getString("capacidade"));

                    voo.setAviao(origem);
                }


                lista.add(voo);

            }
        }

        return lista;
    }
}
