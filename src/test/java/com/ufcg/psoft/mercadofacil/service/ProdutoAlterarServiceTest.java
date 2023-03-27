package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.repository.*;
import com.ufcg.psoft.mercadofacil.model.Produto;
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
    ProdutoAlterarServiceTest driver;
    ProdutoRepository<Produto, Long> produtoRepository;
    Produto produto;
    @BeforeEach
    void setup(){
        produto = produtoRepository.find(10L);
    }

    @Test
    @DisplayName("Quando altero o nome do produto com um nome válido")
    void alterarNomeDoProduto(){
        /* AAA*/
        //Arrange
        produto.setNome("Nome Produto Alterado");
        Produto resultado = driver.update(produto);
        assertEquals("Nome Produto Alterado", resultado.getNome());
    }
}
