package br.com.senac.exemplologin;

import android.content.Context;
import android.content.SharedPreferences;

import static android.provider.Settings.Global.getString;

/**
 * Created by crist on 26/02/2018.
 */

public class AppExemploLogin {

    public boolean login(Context contexto,String usuario,String senha){
        boolean valido = true;


        SharedPreferences sharedPref = contexto.getSharedPreferences("AppLoginExemplo", Context.MODE_PRIVATE);
        String loginDB = sharedPref.getString("nome","^7j*^$89");
        String senhaDB = sharedPref.getString("senha","^7j*^$89");

        if (!usuario.equals(loginDB) || !senha.equals(senhaDB)) {
            valido = false;
        }


        return valido;
    }


    public String cadastrar(Context contexto, String nome, String login, String senha, String resenha){

        if (nome.length() <= 5){
            return "Nome deve ser maior que 5 caracteres.";
        }

        if (login.length() <= 5){
            return "Login deve ser maior que 5 caracteres.";
        }

        if (senha.length() <= 5){
            return "senha deve ser maior que 5 caracteres.";
        }

        if (!senha.equals(resenha)){
            return "senha incorreta, tente novamente.";
        }

        //salvar no banco
        salvarNoDB(contexto, nome, login, senha);

        return "OK";


    }

    private void salvarNoDB(Context contexto, String nome,String login,String senha) {

        SharedPreferences sharedPref = contexto.getSharedPreferences("AppLoginExemplo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nome", nome);
        editor.putString("login", login);
        editor.putString("senha", senha);
        editor.commit();
    }

}
