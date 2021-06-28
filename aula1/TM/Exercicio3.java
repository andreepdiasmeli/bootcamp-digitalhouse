package com.mercadolivre;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio3 {

    static class Produto {
        String nome;
        BigDecimal preco;
        Integer quantidade;

        public Produto(String nome, String preco, Integer quantidade) {
            this.nome = nome;
            this.preco = new BigDecimal(preco);
            this.quantidade = quantidade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Produto> produtos = lerProdutos(scanner);

        BigDecimal valorTotal = calcularValorTotal(produtos);

        imprimirProdutos(produtos, valorTotal);
    }

    private static void imprimirProdutos(List<Produto> produtos, BigDecimal valorTotal) {
        DecimalFormat f = new DecimalFormat("##.00");
        for(int i = 1; i < 3; i++){
            System.out.println("Produto " + i);
            System.out.println(produtos.get(i).nome);
            System.out.println("R$" + f.format(produtos.get(i).preco));
            System.out.println("Quantidade: " + produtos.get(i).quantidade);
            System.out.println();
        }
        System.out.println("Valor Total: R$" + f.format(valorTotal));
    }

    private static List<Produto> lerProdutos(Scanner scanner) {
        String preco;
        Integer quantidade;
        String nome;
        List<Produto> produtos = new ArrayList<>();

        for(int i = 1; i <= 3; i++){
            nome = scanner.nextLine().trim();
            preco = scanner.nextLine().trim();
            quantidade = Integer.parseInt(scanner.nextLine().trim());

            produtos.add(new Produto(nome, preco, quantidade));
        }
        return produtos;
    }

    private static BigDecimal calcularValorTotal(List<Produto> produtos) {
        BigDecimal valorTotal = BigDecimal.ZERO;

        for(Produto produto : produtos){
            valorTotal = valorTotal.add(produto.preco.multiply(new BigDecimal(produto.quantidade)));
        }
        return valorTotal;
    }

}
