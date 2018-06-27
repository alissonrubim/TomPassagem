package com.example.aluno.tompassagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aluno.tompassagem.helper.ListaPoltronaAdapter;
import com.example.aluno.tompassagem.models.Voo;

import org.w3c.dom.Text;

public class DetalhesVooActivity extends AppCompatActivity {

    private Button btnComprar;
    private TextView txtOrigem, txtDestino, txtAeroO, txtAeroD, txtDataViagem, txtPrefixo, txtModelo, txtCap;
    private Voo voo;
    private int vooindex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_voo);

        vooindex = getIntent().getExtras().getInt("VooIndex");
        voo = ListaVooActivity.listaVoo.get(vooindex);

        binding();

        txtOrigem.setText(voo.getOrigem().getCidade());
        txtDestino.setText(voo.getDestino().getCidade());
        txtAeroD.setText(voo.getDestino().getAeroporto());
        txtAeroO.setText(voo.getOrigem().getAeroporto());
        txtDataViagem.setText(voo.getData());
        txtPrefixo.setText(voo.getAviao().getPrefixo());
        txtModelo.setText(voo.getAviao().getModelo());
        txtCap.setText(voo.getAviao().getCapacidade());


        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListaPoltronaActivity.class);
                intent.putExtra("VooIndex", vooindex);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1 && resultCode == RESULT_OK){
            finish();
        }
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
