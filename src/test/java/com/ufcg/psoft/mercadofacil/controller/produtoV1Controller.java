package com.ufcg.psoft.mercadofacil.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ufcg.psoft.mercadofacil.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Testes do Controller de Produtos")
public class ProdutoV1Controller {

    @Autowired
    MockMvc mockMvc;

    Produto produto;

    @BeforeEach
    void setup(){
        produto = Produto.builder()
                .id(10)
                .nome("Produto 10")
                .codigoBarra("123456789")
                .fabricante("Fabricante 10")
                .preco(125.36)
                .build();
    }

    @Test
    @DisplayName("Quando altero o produto com nome válido")
    void alteroProdutoComNomeValido() throws JsonProcessingException {
        // Arrange
        produto.setNome("Chiclete");
        // Act
        produtoModificadoJSONString = mockMvc.perform(
                put("/produto/" + 10)
                .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
    }
}
