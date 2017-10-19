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
    EditText editTextRaca;
    EditText editTextAteque;
    EditText editTextDefesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickCadastrar(View v){

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextIdade = (EditText) findViewById(R.id.editTextIdade);

        editTextRaca = (EditText) findViewById(R.id.editTextRaca);

        editTextAteque = (EditText) findViewById(R.id.editTextAtaque);
        editTextDefesa = (EditText) findViewById(R.id.editTextDefesa);

        personagen = new Personagem();

        personagen.setNome(editTextNome.getText().toString());
        personagen.setRaca(editTextRaca.getText().toString());
        personagen.setIdade(Integer.parseInt(editTextIdade.getText().toString()));
        personagen.setAtaque(Float.parseFloat(editTextAteque.getText().toString()));
        personagen.setDefesa(Float.parseFloat(editTextDefesa.getText().toString()));

        String erros = personagen.isValid();

        if (erros == null) {

            Toast.makeText(this,"Cadastrado com Sucesso!",Toast.LENGTH_SHORT).show();

        }else{

            Toast.makeText(this,erros,Toast.LENGTH_SHORT).show();

        }



    }
}
