package com.example.dev.personagensrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Personagem personagen;
    EditText editTextNome;
    EditText editTextIdade;

    EditText editTextAteque;
    EditText editTextDefesa;

    RadioButton radioButtonAnao;
    RadioButton radioButtonHumano;
    RadioButton radioButtonMago;
    RadioButton radioButtonElfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickCadastrar(View v){

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextIdade = (EditText) findViewById(R.id.editTextIdade);

        radioButtonHumano = (RadioButton) findViewById(R.id.radioButtonHumano);
        radioButtonAnao = (RadioButton) findViewById(R.id.radioButtonAnao);
        radioButtonElfo = (RadioButton) findViewById(R.id.radioButtonElfo);
        radioButtonMago = (RadioButton) findViewById(R.id.radioButtonMago);

        editTextAteque = (EditText) findViewById(R.id.editTextAtaque);
        editTextDefesa = (EditText) findViewById(R.id.editTextDefesa);

        personagen = new Personagem();

        personagen.setNome(editTextNome.getText().toString());


        if (radioButtonHumano.isChecked()){
            personagen.setRaca("Humano");
        }

        if (radioButtonElfo.isChecked()){
            personagen.setRaca("Elfo");
        }

        if (radioButtonAnao.isChecked()){
            personagen.setRaca("Anão");
        }

        if (radioButtonMago.isChecked()){
            personagen.setRaca("Mago");
        }


        // personagen.setRaca(editTextRaca.getText().toString());
        personagen.setIdade(Integer.parseInt(editTextIdade.getText().toString()));
        personagen.setAtaque(Float.parseFloat(editTextAteque.getText().toString()));
        personagen.setDefesa(Float.parseFloat(editTextDefesa.getText().toString()));

        String erros = personagen.isValid();

        if (erros == null) {

            //Toast.makeText(this,"Cadastrado com Sucesso!",Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this,DetalhesPersonagemActivity.class);

            startActivity(i);


        }else{

            Toast.makeText(this,erros,Toast.LENGTH_SHORT).show();

        }



    }
}
