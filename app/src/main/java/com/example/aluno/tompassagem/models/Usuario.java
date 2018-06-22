package com.example.aluno.tompassagem.models;

/**
 * Created by aluno on 21/06/2018.
 */

public class Usuario {

    String id, email, nome, senha, login;

    public Usuario() {
    }

    public Usuario(String id, String email, String nome, String senha, String login) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
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
}
