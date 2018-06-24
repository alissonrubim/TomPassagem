package com.example.aluno.tompassagem.api;

import com.example.aluno.tompassagem.models.Poltrona;
import com.example.aluno.tompassagem.models.Voo;


import org.json.JSONException;

import java.util.ArrayList;

public class VooApi extends Api {
    public ArrayList<Voo> BuscarTodos() throws Exception {
        String JSONresult = this.Execute("voo",  null, Api.UsuarioLogado.getToken(), "GET");
        return (new Voo()).JSONtoList(JSONresult);
    }

    public ArrayList<Poltrona> BuscaPoltronas(String vooId) throws Exception {
        String JSONresult = this.Execute("voo/" + vooId + "/poltronas",  null, Api.UsuarioLogado.getToken(), "GET");
        return (new Poltrona()).JSONtoList(JSONresult);
    }
}
