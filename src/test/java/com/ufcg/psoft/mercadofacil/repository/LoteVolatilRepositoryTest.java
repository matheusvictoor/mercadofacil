package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class LoteVolatilRepositoryTest {

    @Autowired
    LoteVolatilRepository driver;
    Lote lote;
    Lote resultado;
    Produto produto;

    @BeforeEach
    void setUp() {
        produto = Produto.builder()
                .id(1L)
                .nome("Produto Base")
                .codigoDeBarras("123456789")
                .fabricante("Fabricante Base")
                .preco(125.36)
                .build();
        lote = Lote.builder()
                .id(1L)
                .numeroDeItens(100)
                .produto(produto)
                .build();
    }

    @AfterEach
    void tearDown() {
        produto = null;
        driver.deleteAll();
    }

    @Test
    @DisplayName("Adicionar o primeiro Lote no repositório de dados")
    void save() {
        resultado = driver.save(lote);
        assertEquals(driver.findAll().size(), 1);
        assertEquals(resultado.getId(), lote.getId());
        assertEquals(resultado.getProduto(), produto);
    }

    @Test
    @DisplayName("Adicionar o segundo Lote (ou posterior) no repositorio de dados")
    void salvarSegundoLoteOuPosterior() {
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoDeBarras("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(100)
                .produto(produtoExtra)
                .build();

        driver.save(lote);
        resultado = driver.save(loteExtra);

        assertEquals(driver.findAll().size(), 2);
        assertTrue(driver.findAll().contains(lote));
        assertTrue(driver.findAll().contains(loteExtra));
        assertEquals(resultado.getId(), loteExtra.getId());
        assertEquals(resultado.getProduto(), produtoExtra);
    }

    @Test
    @DisplayName("Buscar Lote por ID")
    void find() {
        driver.save(lote);
        resultado = driver.find(1L);
        assertEquals(resultado.getId(), lote.getId());
        assertEquals(resultado.getProduto(), produto);
    }

    @Test
    @DisplayName("Atualizar lote no repositorio de dados")
    void update() {
        driver.save(lote);
        Lote novoLote = Lote.builder()
                .id(1L)
                .numeroDeItens(50)
                .produto(produto)
                .build();
        resultado = driver.update(novoLote);
        assertEquals(resultado.getNumeroDeItens(), 50);
        assertEquals(driver.find(1L).getNumeroDeItens(), 50);
    }

    @Test
    @DisplayName("Encontrar todos os lotes")
    void findAll() {
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoDeBarras("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(50)
                .produto(produtoExtra)
                .build();

        driver.save(lote);
        driver.save(loteExtra);

        List<Lote> lotesEncontrados = driver.findAll();
        assertEquals(lotesEncontrados.size(), 2);
        assertTrue(lotesEncontrados.contains(lote));
        assertTrue(lotesEncontrados.contains(loteExtra));
    }

    @Test
    @DisplayName("Deletar lote")
    void delete() {
        driver.save(lote);
        driver.delete(lote);
        assertEquals(driver.findAll().size(), 0);
    }

    @Test
    @DisplayName("Deletar todos os lotes")
    void deleteAll() {
        Produto produtoExtra = Produto.builder()
                .id(2L)
                .nome("Produto Extra")
                .codigoDeBarras("987654321")
                .fabricante("Fabricante Extra")
                .preco(125.36)
                .build();
        Lote loteExtra = Lote.builder()
                .id(2L)
                .numeroDeItens(50)
                .produto(produtoExtra)
                .build();

        driver.save(lote);
        driver.save(loteExtra);

        driver.deleteAll();
        assertEquals(driver.findAll().size(), 0);
    }
}
