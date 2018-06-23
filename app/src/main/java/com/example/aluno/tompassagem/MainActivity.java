package com.example.aluno.tompassagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.tompassagem.Service.ServicoLogin;
import com.example.aluno.tompassagem.models.Usuario;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnCad;
    EditText edtLogin, edtSenha;
    String token = "",resp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, NovoUsuarioActivity.class);

                startActivity(it);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    resp = new ServicoLogin().execute(edtLogin.getText().toString(), edtSenha.getText().toString()).get();
                    token = resp.substring(resp.indexOf("token")+8,resp.indexOf("}")-1);
                } catch (Exception e) {
                    resp = e.getMessage();
                }

                Toast.makeText(getApplicationContext(),resp+" - "+token,Toast.LENGTH_LONG).show();

                Intent it = new Intent(MainActivity.this, PesquisarVoosActivity.class);

                startActivity(it);
            }
        });


    }

    private void binding() {
        btnLogin = findViewById(R.id.btnLogin);
        btnCad = findViewById(R.id.btnCadastro);
        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);
    }
}
