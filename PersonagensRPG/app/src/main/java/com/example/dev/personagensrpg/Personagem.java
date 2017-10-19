package com.example.dev.personagensrpg;

import java.io.Serializable;

/**
 * Created by dev on 10/4/17.
 */

public class Personagem implements Serializable {

    private String nome;
    private String raca;
    private int idade;
    private float ataque;
    private float defesa;


    public Personagem(String nome, String raca, int idade, float ataque, float defesa) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public Personagem() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public String getIdadeString() {
        return String.valueOf(idade);
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAtaque() {
        return ataque;
    }

    public String getAtaqueString() {
        return String.valueOf(this.ataque);
    }

    public void setAtaque(float ataque) {
        this.ataque = ataque;
    }

    public float getDefesa() {
        return defesa;
    }

    public String getDefesaString() {
        return String.valueOf(this.defesa);
    }
    public void setDefesa(float defesa) {
        this.defesa = defesa;
    }

    public String isValid(){

        if (this.nome.length() < 1){
            return "Nome deve ser informado";
        }

        if (this.raca.length() < 1){
            return "Raca deve ser informado";

        }else if (!this.raca.equalsIgnoreCase("humano") && !this.raca.equalsIgnoreCase("anão")  && !this.raca.equalsIgnoreCase("elfo") && !this.raca.equalsIgnoreCase("mago") ){
            return  "A raça deve ser humano, anão, elfo ou Mago";

        }

        return null;
    }
}
