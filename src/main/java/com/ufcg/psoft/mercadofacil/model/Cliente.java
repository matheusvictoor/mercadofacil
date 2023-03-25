package com.ufcg.psoft.mercadofacil.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente {

    private long id;
    private long cpf;
    private String nome;
    private int idade;
    private String endereco;

    public Cliente(long id, long cpf, String nome, int idade, String endereco) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente-> " + "id: " + id + " cpf: " + cpf + " nome: " + nome + " idade: " + idade + " endereco: " + endereco;
    }
}
