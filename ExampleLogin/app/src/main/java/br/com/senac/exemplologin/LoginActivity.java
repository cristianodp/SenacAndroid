package br.com.senac.exemplologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsuario;
    private EditText editTextSenha;
    private Button buttonEntrar;

    private AppExemploLogin app;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextSenha = (EditText)  findViewById(R.id.editTextSenha);
        buttonEntrar = (Button) findViewById(R.id.buttonEntrar);

        app = new AppExemploLogin();

        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean valido = app.login(editTextUsuario.getText().toString()
                                ,editTextSenha.getText().toString());

                if (valido){
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this,"Login invalido",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
