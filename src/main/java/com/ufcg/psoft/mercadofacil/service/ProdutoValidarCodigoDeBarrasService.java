package com.ufcg.psoft.mercadofacil.service;


import org.springframework.stereotype.Service;

@Service
public class ProdutoValidarCodigoDeBarrasService {
    public int validarCodigoDeBarras(String codigoDeBarras) throws IllegalArgumentException {

        if (codigoDeBarras.length() != 13)
            throw new IllegalArgumentException("Código de barras com comprimento incorreto!");

        if (codigoDeBarras == null)
            throw new IllegalArgumentException("Código de barras não pode ser nulo!");

        if (!codigoDeBarras.matches("\\d+"))
            throw new IllegalArgumentException("Código de barras contém caractere inválido");

        int a = 0;
        int b = 0;
        int tam = codigoDeBarras.length();

        for (int i = 0; i < tam - 1; i++) {
            if (i % 2 != 0) {
                a += Character.getNumericValue(codigoDeBarras.charAt(i));
            } else {
                b += Character.getNumericValue(codigoDeBarras.charAt(i));
            }
        }

        int soma = (a * 3) + b;
        int codigoFerificador = 10 - (soma % 10);
        int ultimoDigito = Character.getNumericValue(codigoDeBarras.charAt(tam - 1));

        if (codigoFerificador == ultimoDigito){
            return codigoFerificador;
        }
        return -1;
    }
}

