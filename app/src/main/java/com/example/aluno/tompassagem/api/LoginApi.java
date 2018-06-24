package com.example.aluno.tompassagem.api;

import java.io.IOException;

public class LoginApi extends Api {
    public String Login(String login, String senha) throws Exception {
        String JSONresult = this.Execute("usuarios/login",  "{\"login\": \""+login+"\"," +
                "\"senha\": \""+senha+"\" }", null, "POST");
        return JSONresult;
    }
}
