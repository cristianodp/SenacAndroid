package br.com.senac.exemplologin;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by crist on 28/02/2018.
 */

public class CadastrarActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextLogin;
    private EditText editTextSenha;
    private EditText editTextReSenha;
    private Button buttonCadastrar;

    private AppExemploLogin app;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastrar);

        editTextNome    = (EditText) findViewById(R.id.editTextNome);
        editTextLogin   = (EditText) findViewById(R.id.editTextLogin);
        editTextSenha   = (EditText) findViewById(R.id.editTextSenha);
        editTextReSenha = (EditText) findViewById(R.id.editTextReSenha);
        buttonCadastrar = (Button) findViewById(R.id.buttonCadastrar);

        app = new AppExemploLogin();
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ret = app.cadastrar(CadastrarActivity.this
                        ,editTextNome.getText().toString()
                        ,editTextLogin.getText().toString()
                        ,editTextSenha.getText().toString()
                        ,editTextReSenha.getText().toString());

                if (ret.equals("OK")){
                    Toast.makeText(CadastrarActivity.this, "Cadastro Realizado Com Sucesso",Toast.LENGTH_SHORT).show();
                    CadastrarActivity.this.finish();
                }else {
                    Toast.makeText(CadastrarActivity.this, ret,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
