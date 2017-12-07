package com.example.dev.listadecomprasapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextComprar;
    ListView listView;
    AdapterItemComprar adapter;
    List<ItemCompra> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextComprar = (EditText) findViewById(R.id.editTextCompra);
        listView = (ListView) findViewById(R.id.listView);

        lista = new ArrayList<ItemCompra>();



        adapter = new AdapterItemComprar(this,lista);

        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                lista.remove(i);
                adapter.notifyDataSetChanged();

                return false;
            }
        });

    }

    public void clickAdd(View v){
        //Pegar item comprado


        ItemCompra itemCompra =  new ItemCompra();
        itemCompra.nome = editTextComprar.getText().toString();
        itemCompra.comprado = false;

        //Limpar campo na tela
        editTextComprar.setText("");

        //Adicionar item
        lista.add(itemCompra);

        //notificar o adapter que um novo item foi adicionado
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mn_limpar){
            lista.clear();
            adapter.notifyDataSetChanged();
        }

        return super.onOptionsItemSelected(item);
    }
}
