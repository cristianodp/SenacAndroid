package com.example.dev.revisao;

/**
 * Created by dev on 2/7/18.
 */

public class Contador {

    private int x;


    public Contador(){
        x  = 0;
    }

    public void Agregar(){
        x = x +1;
    }


    public String Resultado(){
        return "Conta :" + x;
    }

}
