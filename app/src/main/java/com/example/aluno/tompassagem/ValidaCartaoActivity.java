package com.example.aluno.tompassagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aluno.tompassagem.api.Api;
import com.example.aluno.tompassagem.api.CartaoApi;
import com.example.aluno.tompassagem.api.LoginApi;
import com.example.aluno.tompassagem.api.VooApi;
import com.example.aluno.tompassagem.helper.ListaVooAdapter;
import com.example.aluno.tompassagem.models.Cartao;
import com.example.aluno.tompassagem.models.Usuario;
import com.example.aluno.tompassagem.models.Voo;

import java.io.IOException;

public class ValidaCartaoActivity extends AppCompatActivity {
    Button btnVoltarDetalhe, btnConfirmar;
    EditText edtNumCar, edtMes, edtAno, edtCodSeg;
    TextView textViewValor;
    private String poltronaId;
    private int  vooindex;
    private Voo voo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valida_cartao);

        vooindex = getIntent().getExtras().getInt("VooId");
        poltronaId = getIntent().getExtras().getString("PoltronaId");

        binding();

        voo = ListaVooActivity.listaVoo.get(vooindex);
        textViewValor.setText( voo.getValorPass());

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String json = (new CartaoApi()).Cartao(edtNumCar.getText().toString(), edtMes.getText().toString(),
                            edtAno.getText().toString(), edtCodSeg.getText().toString(),  voo.getValorPass());

                    if(json.isEmpty()){
                        Toast.makeText(getApplicationContext(),"Dados do cartão incorreto",Toast.LENGTH_LONG).show();
                    }else{
                        Cartao cartao = new Cartao();
                        cartao = cartao.applyJSON(json);
                        if(cartao.getStatus().toUpperCase().equals("APROVADO")) {
                            Intent it = new Intent(getApplicationContext(), ListaVooActivity.class);
                            (new VooApi()).CompraPoltrona(voo.getId(), poltronaId);
                            Toast.makeText(getApplicationContext(), "Compra efetuada com sucesso !", Toast.LENGTH_LONG).show();
                            startActivity(it);
                            finish();
                            setResult(RESULT_OK);
                        }else{
                            Toast.makeText(getApplicationContext(), "Cartão Reprovado !", Toast.LENGTH_LONG).show();
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void binding() {
        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnVoltarDetalhe = findViewById(R.id.btnVoltarDetalhes);
        edtNumCar = findViewById(R.id.edtNumCar);
        edtMes = findViewById(R.id.edtMes);
        edtAno = findViewById(R.id.edtAno);
        edtCodSeg = findViewById(R.id.edtCodSeg);
        textViewValor = findViewById(R.id.textViewValor);
    }
}
