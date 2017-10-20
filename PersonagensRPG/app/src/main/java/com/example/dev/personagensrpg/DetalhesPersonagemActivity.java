package com.example.dev.personagensrpg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalhesPersonagemActivity extends AppCompatActivity {

    TextView textViewNome;
    TextView textViewRaca;
    TextView textViewIdade;
    TextView textViewAtaque;
    TextView textViewDefesa;
    ImageView imageViewPersonagem;

    Personagem p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_personagem);


        textViewNome = (TextView) findViewById(R.id.textViewNome);
        textViewRaca = (TextView) findViewById(R.id.textViewRaca);
        textViewIdade = (TextView) findViewById(R.id.textViewIdade);
        textViewAtaque = (TextView) findViewById(R.id.textViewAtaque);
        textViewDefesa = (TextView) findViewById(R.id.textViewDefesa);

        imageViewPersonagem = (ImageView) findViewById(R.id.imageViewPersonagem);


    }
}
