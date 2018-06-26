package com.example.aluno.tompassagem.models;

import com.example.aluno.tompassagem.api.ApiModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aluno on 21/06/2018.
 */

public class Usuario implements ApiModel {

    private String id, email, nome, senha, login, token;

    public Usuario() {
    }

    public Usuario(String id, String email, String nome, String senha, String login, String token) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toJSON() {
        JSONObject jsonObject= new JSONObject();
        try {
            jsonObject.put("id", getId());
            jsonObject.put("email", getEmail());
            jsonObject.put("nome", getNome());
            jsonObject.put("login", getLogin());
            jsonObject.put("senha", getSenha());

            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void applyJSON(String json) {
        Usuario result = null;
        try {
            JSONObject object = new JSONObject(json);
            if(object.has("id"))
            this.setId(object.getString("id"));
            if(object.has("token"))
            this.setToken(object.getString("token"));
            if(object.has("login"))
                this.setLogin(object.getString("login"));
            if(object.has("nome"))
                this.setNome(object.getString("nome"));
            if(object.has("email"))
                this.setEmail(object.getString("email"));
            if(object.has("senha"))
                this.setEmail(object.getString("senha"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
