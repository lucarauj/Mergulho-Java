package modelo.atm;

import modelo.pagamento.Conta;
import modelo.pagamento.DocumentoEstornavel;
import modelo.pagamento.DocumentoPagavel;

public class CaixaEletronico {

    public void imprimirSaldo(Conta conta) {
        System.out.println("Conta: " + conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo Disponível: " + conta.getSaldoDisponivel() + "\n");
    }

    public void pagar(DocumentoPagavel documento, Conta conta) {

        if (documento.estaPago()) {
            throw new IllegalStateException("Documento já está pago!");
        }

        conta.sacar(documento.getValorTotal());
        documento.quitarPagamento();
    }

    public void estornarPagamento(DocumentoEstornavel documento, Conta conta) {
        if(!documento.estaPago()) {
            throw new IllegalStateException("Documento não está pago");
        }
        conta.depositar(documento.getValorTotal());
        documento.estornarPagamento();
    }
}