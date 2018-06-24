package com.example.aluno.tompassagem.api;

import java.io.Serializable;

public interface ApiModel extends Serializable {
    public String toJSON();
    public void applyJSON(String json);
}
