package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Teste do serviço de validar cógido de barras")
public class ProdutoValidarCodigoDeBarrasServiceTest {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ProdutoValidarCodigoDeBarrasService driver;
    Produto produto;
    @BeforeEach
    void setUp(){
        produto = Produto.builder()
                .codigoDeBarras("7891234567895")
                .nome("Produto Sabonete em Barra")
                .fabricante("Ind. Barras LTDA")
                .preco(6.99)
                .build();
    }

    @AfterEach
    void tearDown() {
        produtoRepository.deleteAll();
    }

    @Test
    @DisplayName("O código de barras será verificado antes do produto ser salvo")
    void verificaCodigoDeBarras() {
        // Arrange

        // Act
        int resultado = driver.validarCodigoDeBarra("7891234567895");

        // Assert
        Assertions.assertEquals(resultado, 5);

    }
}
