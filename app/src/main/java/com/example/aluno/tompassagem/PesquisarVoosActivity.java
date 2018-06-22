package com.example.aluno.tompassagem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PesquisarVoosActivity extends AppCompatActivity {

    EditText edtIda, edtVolta;
    Spinner spnOrigem, spnDestino;
    Button btnPesqVoo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_voos);

        binding();
    }

    private void binding() {
        edtIda = findViewById(R.id.edtIda);
        edtVolta = findViewById(R.id.edtVolta);
        spnOrigem = findViewById(R.id.spnOrigem);
        spnDestino = findViewById(R.id.spnDestino);
        btnPesqVoo = findViewById(R.id.btnPesqVoo);
    }
}
