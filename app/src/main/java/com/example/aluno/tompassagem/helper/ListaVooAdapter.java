package com.example.aluno.tompassagem.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aluno.tompassagem.R;
import com.example.aluno.tompassagem.models.Voo;

import java.util.ArrayList;

public class ListaVooAdapter extends BaseAdapter{

    private LayoutInflater layoutInflater;
    private ArrayList<Voo> list = new ArrayList<Voo>();

    public ListaVooAdapter(Context context, ArrayList<Voo> voo){
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
        VooListViewLine line;

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.voo_listviewadapter, null);
            line = new VooListViewLine();
            line.textViewInfo = convertView.findViewById(R.id.textViewInfo);
            line.textViewOrigem = convertView.findViewById(R.id.textViewOrigem);
            line.textViewDestino = convertView.findViewById(R.id.textViewDestino);
        }else{
            line = (VooListViewLine) convertView.getTag();
        }

        Voo f = (Voo) getItem(position);
        if(line != null) {
            line.textViewInfo.setText("Voo " + f.getId() + " - " + f.getData());
            line.textViewOrigem.setText(f.getOrigem().getCidade());
            line.textViewDestino.setText(f.getDestino().getCidade());
        }

        return convertView;
    }

    class VooListViewLine {
        public TextView textViewInfo;
        public TextView textViewOrigem;
        public TextView textViewDestino;
    }
}
