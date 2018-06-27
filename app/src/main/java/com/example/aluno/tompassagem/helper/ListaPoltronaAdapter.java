package com.example.aluno.tompassagem.helper;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aluno.tompassagem.R;
import com.example.aluno.tompassagem.models.Poltrona;
import com.example.aluno.tompassagem.models.Voo;

import java.util.ArrayList;

public class ListaPoltronaAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<Poltrona> list = new ArrayList<Poltrona>();

    public ListaPoltronaAdapter(Context context, ArrayList<Poltrona> voo){
        this.list = voo;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PoltronaListViewLine line;

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.poltrona_listviewadapter, null);
            line = new PoltronaListViewLine();
            line.textViewInfo = convertView.findViewById(R.id.textViewInfo);
            line.textViewDisponivel = convertView.findViewById(R.id.textViewDisponivel);
            line.textViewValor = convertView.findViewById(R.id.textViewValor);

        }else{
            line = (PoltronaListViewLine) convertView.getTag();
            if(line == null) {
                line = new PoltronaListViewLine();
                line.textViewInfo = convertView.findViewById(R.id.textViewInfo);
                line.textViewDisponivel = convertView.findViewById(R.id.textViewDisponivel);
                line.textViewValor = convertView.findViewById(R.id.textViewValor);
            }
        }

        Poltrona f = (Poltrona) getItem(position);
        if(line != null) {
            line.textViewInfo.setText("Poltrona " + f.getAssento());
            line.textViewDisponivel.setText(f.getOcupado() ? "sim" : "não");
            line.textViewValor.setText("R$" + f.getValorPassagem());
        }

        return convertView;
    }

    class PoltronaListViewLine {
        public TextView textViewInfo;
        public TextView textViewDisponivel;
        public TextView textViewValor;
    }
}

