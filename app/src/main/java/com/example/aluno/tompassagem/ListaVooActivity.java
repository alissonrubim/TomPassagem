package com.example.aluno.tompassagem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class ListaVooActivity extends AppCompatActivity {

    ListView lstVoo;
    Button btnVoltarP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voo);

        binding();
    }

    private void binding() {
        lstVoo = findViewById(R.id.lstVoos);
        btnVoltarP = findViewById(R.id.btnVoltarP);
    }
}
