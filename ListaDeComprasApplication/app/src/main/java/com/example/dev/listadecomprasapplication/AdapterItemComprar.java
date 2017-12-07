package com.example.dev.listadecomprasapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dev on 12/7/17.
 */

public class AdapterItemComprar extends BaseAdapter {

    private List<ItemCompra> lista;
    private Context context;

    public AdapterItemComprar(Context context, List<ItemCompra> lista){
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i) ;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(R.layout.item_comprar, null);

        TextView textView1 = view.findViewById(R.id.textView1);
        CheckBox checkBox1 = view.findViewById(R.id.checkBox1);

        textView1.setText(lista.get(i).nome);
        checkBox1.setChecked(lista.get(i).comprado);

        return view;
    }
}
