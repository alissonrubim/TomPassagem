package com.example.aluno.tompassagem.api;

import com.example.aluno.tompassagem.models.Usuario;

public class UsuarioApi extends Api {
    public boolean Cadastrar(Usuario usuario) throws Exception {
        String JSONresult = this.Execute("usuarios",  usuario.toJSON());
        if(!JSONresult.isEmpty()){
            usuario.applyJSON(JSONresult);
            return true;
        }

        return false;
    }
}
