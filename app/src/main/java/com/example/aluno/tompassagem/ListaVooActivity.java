package com.example.aluno.tompassagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.aluno.tompassagem.api.VooApi;
import com.example.aluno.tompassagem.helper.ListaVooAdapter;
import com.example.aluno.tompassagem.models.Voo;

import java.util.ArrayList;

public class ListaVooActivity extends AppCompatActivity {

    public static ArrayList<Voo> listaVoo = new ArrayList<Voo>();
    private ListView lstVoo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voo);

        binding();

        lstVoo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), DetalhesVooActivity.class);
                intent.putExtra("VooIndex", position);
                startActivity(intent);
            }
        });

        loadListaVoos();
    }

    private void loadListaVoos(){
        try {
            listaVoo = (new VooApi()).BuscarTodos();
            ListaVooAdapter adapter = new ListaVooAdapter(getApplicationContext(), listaVoo);
            lstVoo.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void binding() {
        lstVoo = findViewById(R.id.lstVoos);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 100){

        }
    }
}
