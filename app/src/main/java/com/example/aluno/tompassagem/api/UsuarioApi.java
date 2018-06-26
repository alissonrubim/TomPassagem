package com.example.aluno.tompassagem.api;

import com.example.aluno.tompassagem.models.Usuario;

public class UsuarioApi extends Api {
    public boolean Cadastrar(Usuario usuario) throws Exception {
        String JSONresult = this.Execute("usuarios",  usuario.toJSON(), null, "POST");
        if(!JSONresult.isEmpty()){
            usuario.applyJSON(JSONresult);
            return true;
        }

        //String JSONresult = this.Execute("usuarios/login",  "{\"login\": \""+login+"\"," +
        //        "\"senha\": \""+senha+"\" }", null, "POST");
        //return JSONresult;

        return false;
    }
}
