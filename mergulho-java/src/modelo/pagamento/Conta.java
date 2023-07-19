package modelo.pagamento;

import java.util.Objects;

public abstract class Conta {

    private Pessoa titular;
    private int agencia;
    private int numero;
    private double saldo;

    public Conta() {}

    public Conta(Pessoa titular, int agencia, int numero) {
        Objects.requireNonNull(titular);

        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar (double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        saldo += valor;
    }

    public void sacar (double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
        if (valor > getSaldoDisponivel()) {
            throw new IllegalStateException("Saldo insulficiente");
        }
        saldo -= valor;
    }

    public void sacar (double valor, double taxaSaque) {
        sacar(valor + taxaSaque);
    }

    public double getSaldoDisponivel() {
        return getSaldo();
    }

    public abstract void debitarTarifaMensal();
}
