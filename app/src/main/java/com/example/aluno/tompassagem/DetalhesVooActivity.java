package com.example.aluno.tompassagem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.aluno.tompassagem.models.Voo;

import org.w3c.dom.Text;

public class DetalhesVooActivity extends AppCompatActivity {

    private Button btnComprar;
    private TextView txtOrigem, txtDestino, txtAeroO, txtAeroD, txtDataViagem, txtPrefixo, txtModelo, txtCap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_voo);

        int vooindex = getIntent().getExtras().getInt("VooIndex");
        Voo voo = ListaVooActivity.listaVoo.get(vooindex);

        binding();

        txtOrigem.setText(voo.getOrigem().getCidade());
        txtDestino.setText(voo.getDestino().getCidade());
        txtAeroD.setText(voo.getDestino().getAeroporto());
        txtAeroO.setText(voo.getOrigem().getAeroporto());
        txtDataViagem.setText(voo.getData());
        txtPrefixo.setText(voo.getAviao().getPrefixo());
        txtModelo.setText(voo.getAviao().getModelo());
        txtCap.setText(voo.getAviao().getCapacidade());
    }

    private void binding() {
        btnComprar = findViewById(R.id.btnComprar);
        txtOrigem = findViewById(R.id.txtOrigem);
        txtDestino = findViewById(R.id.txtDestino);
        txtAeroO = findViewById(R.id.txtAeroportoO);
        txtAeroD = findViewById(R.id.txtAeroportoD);
        txtDataViagem = findViewById(R.id.txtDataViagem);
        txtPrefixo = findViewById(R.id.txtPrefixo);
        txtModelo = findViewById(R.id.txtModelo);
        txtCap = findViewById(R.id.txtCapacidade);
    }
}
