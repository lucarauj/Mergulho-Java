package app;

import modelo.atm.CaixaEletronico;
import modelo.excecao.SaldoInsuficienteException;
import modelo.pagamento.*;

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

        try{
            ContaInvestimento contaInvestimento = new ContaInvestimento(titular2, 222, 3336);
            contaInvestimento.depositar (15_000);
            contaInvestimento.sacar(1000);
            contaInvestimento.creditarRendimentos(0.8);

            ContaEspecial contaEspecial = new ContaEspecial(titular3, 026, 2264, 1_000);
            contaEspecial.depositar (15_000);
            contaEspecial.sacar(15_500);

            System.out.println("Titular: " + contaInvestimento.getTitular().getNome());
            System.out.println("Saldo: " + contaInvestimento.getSaldo() + "\n");

            System.out.println("Titular: " + contaEspecial.getTitular().getNome());
            System.out.println("Saldo: " + contaEspecial.getSaldo() + "\n");

            CaixaEletronico ce = new CaixaEletronico();
            ce.imprimirSaldo(contaEspecial);
            ce.imprimirSaldo(contaInvestimento);

            contaEspecial.debitarTarifaMensal();
            contaInvestimento.debitarTarifaMensal();

            System.out.println("Titular: " + contaInvestimento.getTitular().getNome());
            System.out.println("Saldo: " + contaInvestimento.getSaldo() + "\n");

            System.out.println("Titular: " + contaEspecial.getTitular().getNome());
            System.out.println("Saldo: " + contaEspecial.getSaldo() + "\n");

            Boleto boleto = new Boleto(200, titular1);
            ce.pagar(boleto, contaInvestimento);

            System.out.println("Titular: " + contaInvestimento.getTitular().getNome());
            System.out.println("Saldo: " + contaInvestimento.getSaldo() + "\n");

            ce.pagar(new Holerite(titular1, 150, 160), contaInvestimento);

            System.out.println("Titular: " + contaInvestimento.getTitular().getNome());
            System.out.println("Saldo: " + contaInvestimento.getSaldo() + "\n");

            ce.estornarPagamento(boleto, contaInvestimento);

            System.out.println("Titular: " + contaInvestimento.getTitular().getNome());
            System.out.println("Saldo: " + contaInvestimento.getSaldo() + "\n");

            boleto.imprimirRecibo();

        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro '" + e.getMessage() + "' ao executar operacao na conta");
        }




    }
}
