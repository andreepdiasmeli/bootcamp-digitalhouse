package andreepdiasmeli.Exercicio1;

import java.math.BigDecimal;

public class ContaCorrente {

    private String numero;
    private BigDecimal saldo;

    public ContaCorrente() {
    }

    public ContaCorrente(String numero, BigDecimal saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public ContaCorrente(ContaCorrente contaCorrente) {
        this.numero = contaCorrente.getNumero();
        this.saldo = contaCorrente.getSaldo();
    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    public void sacar(BigDecimal valor) {
        if (this.saldo.subtract(valor).compareTo(BigDecimal.ZERO) == -1) {
            throw new RuntimeException("Saldo insuficiente para saque.");
        }
        this.saldo = this.saldo.subtract(valor);
    }

    public void devolver(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    public void transferir(BigDecimal valor, ContaCorrente contaDestino) {
        if (this.saldo.subtract(valor).compareTo(BigDecimal.ZERO) == -1) {
            throw new RuntimeException("Saldo insuficiente para transferência.");
        }
        this.saldo = this.saldo.subtract(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public String toString() {
        return this.getNumero() + ": " + this.getSaldo();
    }

    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente("123", new BigDecimal("100"));
        ContaCorrente c2 = new ContaCorrente("789", new BigDecimal("200"));
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println();

        c1.depositar(new BigDecimal("50"));
        c2.sacar(new BigDecimal("40"));
        c2.devolver(new BigDecimal("20"));
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println();

        c1.transferir(new BigDecimal("100"), c2);
        System.out.println(c1.toString());
        System.out.println(c2.toString());

    }
}
