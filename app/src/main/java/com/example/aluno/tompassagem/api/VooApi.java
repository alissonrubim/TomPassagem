package com.example.aluno.tompassagem.api;

import com.example.aluno.tompassagem.models.Voo;



import java.util.ArrayList;

public class VooApi extends Api {
    public ArrayList<Voo> BuscarTodos() throws Exception {
        String JSONresult = this.Execute("voo",  null, Api.UsuarioLogado.getToken());
        return (new Voo()).JSONtoList(JSONresult);
    }
}
