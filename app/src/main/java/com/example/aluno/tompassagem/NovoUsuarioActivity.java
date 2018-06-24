package com.example.aluno.tompassagem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.tompassagem.api.UsuarioApi;
import com.example.aluno.tompassagem.models.Usuario;

public class NovoUsuarioActivity extends AppCompatActivity {

    private Button btnSalvar;
    private EditText edtLogin, edtSenha, edtNome, edtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        binding();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();
                usuario.setEmail(edtEmail.getText().toString());
                usuario.setNome(edtNome.getText().toString());
                usuario.setLogin(edtLogin.getText().toString());
                usuario.setSenha(edtSenha.getText().toString());
                usuario.setToken("-");
                usuario.setId("0");
                try {
                    if((new UsuarioApi()).Cadastrar(usuario)){
                        Toast.makeText(getApplicationContext(),"Usuário cadastrado com sucesso!",Toast.LENGTH_LONG).show();
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Não foi possível cadastrar um usuário, tente novamente!",Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void binding() {
        btnSalvar = findViewById(R.id.btnSalvar);
        edtEmail = findViewById(R.id.edtEmailCad);
        edtLogin = findViewById(R.id.edtLoginCad);
        edtNome = findViewById(R.id.edtNomeCad);
        edtSenha = findViewById(R.id.edtSenhaCad);
    }
}
