package com.example.aluno.tompassagem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PesquisarVoosActivity extends AppCompatActivity {

    private EditText edtIda, edtVolta;
    private Spinner spnOrigem, spnDestino;
    private Button btnPesqVoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_voos);

        binding();

        btnPesqVoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void binding() {
        edtIda = findViewById(R.id.edtIda);
        edtVolta = findViewById(R.id.edtVolta);
        spnOrigem = findViewById(R.id.spnOrigem);
        spnDestino = findViewById(R.id.spnDestino);
        btnPesqVoo = findViewById(R.id.btnPesqVoo);
    }
}
