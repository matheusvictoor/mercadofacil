package com.ufcg.psoft.mercadofacil.service;



public class ProdutoValidarCodigoDeBarrasService {
    public int validarCodigoDeBarra(String codigoDeBarras) {
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

