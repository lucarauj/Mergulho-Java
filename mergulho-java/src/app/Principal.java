package app;

import modelo.atm.CaixaEletronico;
import modelo.excecao.SaldoInsuficienteException;
import modelo.pagamento.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Principal {
    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("11133355566");
        titular1.setRendimentoAnual(new BigDecimal("15000"));
        titular1.setDataUltimaAtualizacao(LocalDateTime.parse("2023-06-10T13:20:00"));

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Roberta");
        titular2.setDocumento("03432655510");

        Pessoa titular3 = new Pessoa();
        titular3.setNome("Jeremias Albert");
        titular3.setDocumento("24632786510");

        try{
            ContaInvestimento contaInvestimento = new ContaInvestimento(titular2, 222, 3336);
            contaInvestimento.depositar (new BigDecimal("15000"));
            contaInvestimento.sacar(new BigDecimal("1000"));
            contaInvestimento.creditarRendimentos(new BigDecimal("0.8"));

            ContaEspecial contaEspecial = new ContaEspecial(titular3, 026, 2264, new BigDecimal("1000"));
            contaEspecial.depositar (new BigDecimal("15000"));
            contaEspecial.sacar(new BigDecimal("15500"));

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

            Boleto boleto = new Boleto(new BigDecimal("200"), titular1);
            ce.pagar(boleto, contaInvestimento);

            System.out.println("Titular: " + contaInvestimento.getTitular().getNome());
            System.out.println("Saldo: " + contaInvestimento.getSaldo() + "\n");

            ce.pagar(new Holerite(titular1, new BigDecimal("150"), 160), contaInvestimento);

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
