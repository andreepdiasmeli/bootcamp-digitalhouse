package com.mercadolivre;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

public class Exercicio2 {

    static class Empresa{
        public String nome;
        public BigDecimal valor;
        public BigDecimal crescimentoAnual;

        public Empresa(String nome, BigDecimal valor, BigDecimal crescimentoAnual) {
            this.nome = nome;
            this.valor = valor;
            this.crescimentoAnual = crescimentoAnual;
        }

        public void atualizarValor(){
            BigDecimal multiplicadorCrescimento = (crescimentoAnual.add(new BigDecimal("100"))).divide(new BigDecimal("100"));
            this.valor = this.valor.multiply(multiplicadorCrescimento);
        }
    }

    public static void main(String[] args) {

        Empresa empresaX = new Empresa("X", new BigDecimal("1130000"), new BigDecimal("148") );
        Empresa empresaY = new Empresa("Y", new BigDecimal("18400000"), new BigDecimal("32") );

        Integer ano = 2021;

        while (empresaX.valor.compareTo(empresaY.valor) == -1){
            printValorEmpresas(empresaX, empresaY, ano);
            empresaX.atualizarValor();
            empresaY.atualizarValor();
            ano++;
        }

        printValorEmpresas(empresaX, empresaY, ano);
    }

    private static void printValorEmpresas(Empresa empresaX, Empresa empresaY, Integer ano) {
        printValorEmpresa(empresaX, ano);
        printValorEmpresa(empresaY, ano);
        System.out.println();
    }

    private static void printValorEmpresa(Empresa empresaX, Integer ano) {
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.println("Empresa: " + empresaX.nome + " - 01/01/" + ano.toString() + " - Valor da empresa: " + f.format(empresaX.valor.divide(new BigDecimal("1000000"))) + "m");
    }
}
