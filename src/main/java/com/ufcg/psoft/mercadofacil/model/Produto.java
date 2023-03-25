package com.ufcg.psoft.mercadofacil.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Produto {
    private long id;
    private String nome;
    private double preco;
    private String codigoBarra;
    private String fabricante;

    public Produto(long id, String nome, double preco, String codigoBarra, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.codigoBarra = codigoBarra;
        this.fabricante = fabricante;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Produto-> " + "id: " + id + " nome: " + nome + " preco: " + preco + " codigoBarra: " + codigoBarra + " fabricante: " + fabricante;
    }
}
