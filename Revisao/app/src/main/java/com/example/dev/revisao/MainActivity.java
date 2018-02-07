package com.example.dev.revisao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaracão dos atributos/Variaveis
    private TextView textViewContador;
    private Button buttonContar;
    private Contador meuContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vinculando elementos da tela
        textViewContador = (TextView) findViewById(R.id.textViewContador);
        buttonContar = (Button) findViewById(R.id.buttonContar);

        //Iniciando objeto contador
        meuContador = new Contador();

        //implementando click do botão contar
        buttonContar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }

}
