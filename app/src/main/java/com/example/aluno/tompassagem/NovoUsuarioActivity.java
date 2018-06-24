package com.example.aluno.tompassagem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NovoUsuarioActivity extends AppCompatActivity {

    private Button btnSalvar, btnVoltar;
    private EditText edtLogin, edtSenha, edtNome, edtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        binding();
    }

    private void binding() {
        btnSalvar = findViewById(R.id.btnSalvar);
        btnVoltar = findViewById(R.id.btnVoltar);
        edtEmail = findViewById(R.id.edtEmailCad);
        edtLogin = findViewById(R.id.edtLoginCad);
        edtNome = findViewById(R.id.edtNomeCad);
        edtSenha = findViewById(R.id.edtSenhaCad);
    }
}
