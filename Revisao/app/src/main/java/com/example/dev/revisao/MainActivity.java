package com.example.dev.revisao;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaracão dos atributos/Variaveis
    private TextView textViewContador1;
    private Button buttonContar1;
    private TextView textViewContador2;
    private Button buttonContar2;
    private ConstraintLayout container;

    private Contador meuContador1;
    private Contador meuContador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //vinculando elementos da tela
        textViewContador1 = (TextView) findViewById(R.id.textViewContador1);
        buttonContar1 = (Button) findViewById(R.id.buttonContar1);

        textViewContador2 = (TextView) findViewById(R.id.textViewContador2);
        buttonContar2 = (Button) findViewById(R.id.buttonContar2);

        container = (ConstraintLayout) findViewById(R.id.container);

        //Iniciando objeto contador
        meuContador1 = new Contador();
        meuContador2 = new Contador();

        //implementando click do botão contar
        buttonContar1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                meuContador1.Agregar();
                textViewContador1.setText(meuContador1.Resultado());
            }
        });

        buttonContar2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                meuContador2.Agregar();
                textViewContador2.setText(meuContador2.Resultado());
            }
        });

        container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);

                return false;

            }
        });


    }

}
