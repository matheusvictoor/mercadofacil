package com.ufcg.psoft.mercadofacil.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lote {
    private long id;
    private Produto produto;
    private int numeroDeItens;

    public Lote(long id, Produto produto, int numeroDeItens) {
        this.id = id;
        this.produto = produto;
        this.numeroDeItens = numeroDeItens;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQntDeItens() {
        return numeroDeItens;
    }

    public void setQntDeItens(int numeroDeItens) {
        this.numeroDeItens = numeroDeItens;
    }
    @Override
    public String toString() {
        return "Lote-> " + "id:" + id + " produto: " + produto + " qntDeItens: " + numeroDeItens;
    }
}
