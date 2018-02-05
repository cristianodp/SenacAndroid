package br.com.cristianodp.listadecompras;

/**
 * Created by crist on 05/02/2018.
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
