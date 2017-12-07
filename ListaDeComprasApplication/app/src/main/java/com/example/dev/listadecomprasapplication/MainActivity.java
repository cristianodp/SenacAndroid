package com.example.dev.listadecomprasapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextComprar;
    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextComprar = (EditText) findViewById(R.id.editTextCompra);
        listView = (ListView) findViewById(R.id.listView);

        lista = new ArrayList<String>();



        adapter = new ArrayAdapter<String>(this
                ,android.R.layout.simple_list_item_1
                ,android.R.id.text1
                ,lista);

        listView.setAdapter(adapter);

    }

    public void clickAdd(View v){
        //Pegar item comprado
        String itemComprar = editTextComprar.getText().toString();

        //Limpar campo na tela
        editTextComprar.setText("");

        //Adicionar item
        lista.add(itemComprar);

        //notificar o adapter que um novo item foi adicionado
        adapter.notifyDataSetChanged();

    }


}
dd