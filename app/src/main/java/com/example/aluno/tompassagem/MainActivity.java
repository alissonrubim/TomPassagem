package com.example.aluno.tompassagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.tompassagem.api.Api;
import com.example.aluno.tompassagem.api.LoginApi;
import com.example.aluno.tompassagem.models.Usuario;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnCad;
    private EditText edtLogin, edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent it = new Intent(getApplicationContext(), NovoUsuarioActivity.class);
            startActivity(it);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String json = (new LoginApi()).Login(edtLogin.getText().toString(), edtSenha.getText().toString());

                    if(json.isEmpty()){
                        Toast.makeText(getApplicationContext(),"Usuário ou senha incorretos",Toast.LENGTH_LONG).show();
                    }else{
                        Usuario usuario = new Usuario();
                        usuario.applyJSON(json);
                        Api.UsuarioLogado = usuario;
                        Intent it = new Intent(getApplicationContext(), ListaVooActivity.class);
                        startActivity(it);
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
        btnLogin = findViewById(R.id.btnLogin);
        btnCad = findViewById(R.id.btnCadastro);
        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);
    }
}
