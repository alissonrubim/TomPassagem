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
import com.example.aluno.tompassagem.models.Voo;

import java.util.ArrayList;

public class ListaPoltronaActivity extends AppCompatActivity {

    public static ArrayList<Poltrona> listaPoltronas = new ArrayList<>();
    private int vooindex;
    private Voo voo;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_poltrona);

        bind();

        vooindex = getIntent().getExtras().getInt("VooIndex");
        voo = ListaVooActivity.listaVoo.get(vooindex);

        loadListaPolt();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Poltrona poltrona = listaPoltronas.get(position);
                if(poltrona.getOcupado() == true){
                    Toast.makeText(getApplicationContext(), "Esta poltrona já esta ocupada!", Toast.LENGTH_LONG);
                }else{
                    Intent intent = new Intent(getApplicationContext(), ValidaCartaoActivity.class);
                    intent.putExtra("VooId", vooindex);
                    intent.putExtra("PoltronaId", poltrona.getAssento());
                    startActivity(intent);
                }
            }
        });


    }

    private void loadListaPolt(){
        try {
            listaPoltronas = (new VooApi()).BuscaPoltronas(voo.getId());
            for (Poltrona p:listaPoltronas) {
                p.setValorPassagem(voo.getValorPass());
            }
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
