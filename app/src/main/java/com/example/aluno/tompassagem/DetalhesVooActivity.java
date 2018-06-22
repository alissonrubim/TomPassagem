package com.example.aluno.tompassagem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import org.w3c.dom.Text;

public class DetalhesVooActivity extends AppCompatActivity {

    Button btnComprar, btnVoltarList;
    //Text txtOrigem, txtDestino, txtAeroO, txtAeroD, txtDataViagem,
    //txtPrefixo, txtModelo, txtCap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_voo);

        binding();
    }

    private void binding() {
        btnComprar = findViewById(R.id.btnComprar);
        btnVoltarList = findViewById(R.id.btnVoltarList);
    }
}
