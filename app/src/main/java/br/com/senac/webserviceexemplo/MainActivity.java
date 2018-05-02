package br.com.senac.webserviceexemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    EditText editTextPesquisa;
    Button buttonPesquisar;
    TextView textViewResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPesquisa = findViewById(R.id.editTextPesquisa);
        buttonPesquisar = findViewById(R.id.buttonPesquisar);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscaFilmes(editTextPesquisa.getText().toString());
            }
        });


    }


    public void buscaFilmes(String buscar){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.omdbapi.com/?s="+buscar+"&apikey=faa8270c";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url
                , new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textViewResultado.setText(response);
                            }
                },new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                textViewResultado.setText(error.toString());
                            }
                });
        queue.add(stringRequest);

    }
}
