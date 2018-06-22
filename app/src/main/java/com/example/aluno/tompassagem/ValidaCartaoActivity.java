package com.example.aluno.tompassagem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ValidaCartaoActivity extends AppCompatActivity {
    Button btnVoltarDetalhe, btnConfirmar;
    EditText edtNumCar, edtMes, edtAno, edtCodSeg, edtValor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valida_cartao);

        binding();
    }

    private void binding() {
        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnVoltarDetalhe = findViewById(R.id.btnVoltarDetalhes);
        edtNumCar = findViewById(R.id.edtNumCar);
        edtMes = findViewById(R.id.edtMes);
        edtAno = findViewById(R.id.edtAno);
        edtCodSeg = findViewById(R.id.edtCodSeg);
        edtValor = findViewById(R.id.edtValor);
    }
}
