package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DisplayName("Teste do servico de validar cogido de barras")
public class ProdutoValidarCodigoDeBarrasServiceTest {

    @Mock
    ProdutoRepository produtoRepository;

    @InjectMocks
    ProdutoValidarCodigoDeBarrasService driver;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Deve retornar o digito verificador correto para um codigo de barras valido")
    void deveRetornarDigitoVerificadorCorreto() throws IllegalArgumentException{
        // Arrange
        String codigoDeBarras = "7891234567895";

        // Act
        int resultado = driver.validarCodigoDeBarras(codigoDeBarras);

        // Assert
        assertEquals(resultado, 5);

    }

    @Test
    @DisplayName("Deve retornar -1 para um codigo de barras invalido")
    void deveRetornarMenosUmParaCodigoDeBarrasInvalido() throws IllegalArgumentException {
        // Arrange
        String codigoDeBarras = "7891234567890";

        // Act
        int resultado = driver.validarCodigoDeBarras(codigoDeBarras);

        // Assert
        assertEquals(resultado, -1);
    }

    @Test
    @DisplayName("Deve lancar uma excecao para um codigo de barras com comprimento incorreto")
    void deveLancarExcecaoParaCodigoDeBarrasComComprimentoIncorreto(){
        // Arrange
        String codigoDeBarras = "123456789";

        // Act
        Throwable excecao = assertThrows(IllegalArgumentException.class, () -> {
            driver.validarCodigoDeBarras(codigoDeBarras);
        });

        // Assert
        assertEquals("Código de barras com comprimento incorreto!", excecao.getMessage());

    }

    @Test
    @DisplayName("Deve lancar uma excecao para um codigo de barras com caracteres invalidos")
    void deveLancarUmExcecaoParaCodigoDeBarrasCOmCaracterInvalidos(){
        // Arrange
        String codigoDeBarras = "789123456789X";

        // Act e Assert
        assertThrows(IllegalArgumentException.class, () -> {
            driver.validarCodigoDeBarras(codigoDeBarras);
        });

    }
}
