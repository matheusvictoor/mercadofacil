package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.repository.*;
import com.ufcg.psoft.mercadofacil.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Testes para a alteração do Produto")
public class ProdutoAlterarServiceTest {

    @Autowired
    ProdutoAlterarService driver;

    @Autowired
    ProdutoRepository produtoRepository;
    Produto produto;
    @BeforeEach
    void setup() {
        produto = produtoRepository.save(Produto.builder()
                .codigoDeBarras("7899137500104")
                .nome("Produto Dez")
                .fabricante("Empresa Dez")
                .preco(450.00)
                .build()
        );
    }

    @AfterEach
    void tearDown(){
        produtoRepository.deleteAll();
    }

    @Test
    @DisplayName("Quando altero o nome do produto com dados válidos")
    void alterarNomeDoProduto() {
        //Arrange
        produto.setNome("Nome Produto Alterado");
        //Act
        Produto resultado = driver.alterar(produto);
        //Assert
        assertEquals("Nome Produto Alterado", resultado.getNome());
    }

    @Test
    @DisplayName("Quando o preço é menor ou igual a zero")
    void precoMenorIgualAZero() {
        //Arrange
        produto.setPreco(0.0);
        //Act
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> driver.alterar(produto)
        );
        //Assert
        assertEquals("Preco invalido!", thrown.getMessage());
    }

    @Test
    @DisplayName("Quando um novo nome válido for fornecido para o produto")
    void quandoNovoNomeValido() {
        // Arrange
        produto.setNome("Produto Dez Atualizado");

        // Act
        Produto resultado = driver.alterar(produto);

        // Assert
        assertEquals("Produto Dez Atualizado", resultado.getNome());
    }
}
