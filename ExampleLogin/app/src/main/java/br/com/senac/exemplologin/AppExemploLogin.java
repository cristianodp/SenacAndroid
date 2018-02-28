package br.com.senac.exemplologin;

/**
 * Created by crist on 26/02/2018.
 */

public class AppExemploLogin {

    public boolean login(String usuario,String senha){
        boolean valido = true;

        if (!usuario.equals("Admin") || !senha.equals("abc123")) {
            valido = false;
        }

        return valido;
    }

}
