package com.example.dev.listadecomprasapplication;

/**
 * Created by dev on 12/7/17.
 */

public class ItemDeCompra {
    private String descricao;
    private Boolean comprado;
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Boolean getComprado() {
        return comprado;
    }
    public void setComprado(Boolean comprado) {
        this.comprado = comprado;
    }
}