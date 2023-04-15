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

}
