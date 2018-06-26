package com.example.aluno.tompassagem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aluno.tompassagem.api.VooApi;
import com.example.aluno.tompassagem.helper.ListaPoltronaAdapter;
import com.example.aluno.tompassagem.helper.ListaVooAdapter;
import com.example.aluno.tompassagem.models.Poltrona;

import java.util.ArrayList;

public class ListaPoltronaActivity extends AppCompatActivity {

    public static ArrayList<Poltrona> listaPoltronas = new ArrayList<>();
    private String vooId;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_poltrona);

        bind();

        vooId = getIntent().getExtras().getString("VooId");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Poltrona poltrona = listaPoltronas.get(position);
                if(poltrona.getOcupado()){
                    Toast.makeText(getApplicationContext(), "Esta poltrona já esta ocupada!", Toast.LENGTH_LONG);
                }else{
                    Intent intent = new Intent(getApplicationContext(), ValidaCartaoActivity.class);
                    intent.putExtra("VooIndex", position);
                    startActivity(intent);
                }
            }
        });

        loadListaPolt();
    }

    private void loadListaPolt(){
        try {
            listaPoltronas = (new VooApi()).BuscaPoltronas(vooId);
            ListaPoltronaAdapter adapter = new ListaPoltronaAdapter(getApplicationContext(), listaPoltronas);
            listView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bind(){
        listView = findViewById(R.id.listView);
    }
}
