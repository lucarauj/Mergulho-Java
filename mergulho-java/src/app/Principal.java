package app;

import modelo.Conta;
import modelo.Pessoa;

public class Principal {
    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("11133355566");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Roberta");
        titular2.setDocumento("03432655510");

        Conta minhaConta = new Conta(titular1, 123, 987);

        minhaConta.depositar (15_000);
        minhaConta.sacar(1_000);

        Conta suaConta = new Conta(titular2, 222, 333);

        suaConta.depositar (30_000);

        System.out.println("Titular: " + minhaConta.getTitular().getNome());
        System.out.println("Saldo: " + minhaConta.getSaldo());

        System.out.println("Titular: " + suaConta.getTitular().getNome());
        System.out.println("Saldo: " + suaConta.getSaldo());
    }
}
