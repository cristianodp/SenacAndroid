package br.com.senac.listademercadooffline;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText editTextDescricao;
    private Button add;

    private ArrayAdapter<String> adapter;
    private List<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        editTextDescricao = findViewById(R.id.itemComprar);

        add = findViewById(R.id.btAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.add(editTextDescricao.getText().toString());
                adapter.notifyDataSetChanged();
                salvar();
            }
        });


        carregaListaDoBancoDeDados();


    }


    public void salvar(){

        Gson gson = new Gson();
        Type typeListaDeItem = new TypeToken<List<String>>(){}.getType();
        String json = gson.toJson(lista, typeListaDeItem);

        SharedPreferences sharedPref = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("lista",json);
        editor.commit();

    }


    public void carregaListaDoBancoDeDados(){
        SharedPreferences sharedPref = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        String json = sharedPref.getString("lista","");

        Gson gson = new Gson();
        Type typeListaDeItem = new TypeToken<List<String>>(){}.getType();

        List<String> listaDoBanco = gson.fromJson(json, typeListaDeItem);

        if (listaDoBanco != null && listaDoBanco.size() > 0){
            this.lista = listaDoBanco;
        }

        adapter = new ArrayAdapter<String>(this
                , android.R.layout.simple_list_item_1
                , lista
        );

        listView.setAdapter(adapter);



    }
}
