package app;

import modelo.*;

public class Principal {
    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("11133355566");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Roberta");
        titular2.setDocumento("03432655510");

        Pessoa titular3 = new Pessoa();
        titular3.setNome("Jeremias Albert");
        titular3.setDocumento("24632786510");

        Conta minhaConta = new Conta(titular1, 123, 987);
        minhaConta.depositar (30_000);
        minhaConta.sacar(1_000);

        ContaInvestimento contaInvestimento = new ContaInvestimento(titular2, 222, 3336);
        contaInvestimento.depositar (15_000);
        contaInvestimento.sacar(1000);
        contaInvestimento.creditarRendimentos(0.8);

        ContaEspecial contaEspecial = new ContaEspecial(titular3, 026, 2264, 1_000);
        contaEspecial.depositar (15_000);
        contaEspecial.sacar(15_500);

        System.out.println("Titular: " + minhaConta.getTitular().getNome());
        System.out.println("Saldo: " + minhaConta.getSaldo());

        System.out.println("Titular: " + contaInvestimento.getTitular().getNome());
        System.out.println("Saldo: " + contaInvestimento.getSaldo());

        System.out.println("Titular: " + contaEspecial.getTitular().getNome());
        System.out.println("Saldo: " + contaEspecial.getSaldo());

        CaixaEletronico ce = new CaixaEletronico();
        ce.imprimirSaldo(minhaConta);
        ce.imprimirSaldo(contaEspecial);
        ce.imprimirSaldo(contaInvestimento);
    }
}
