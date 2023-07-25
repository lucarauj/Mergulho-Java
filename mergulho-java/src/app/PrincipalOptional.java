package app;

import modelo.Banco;
import modelo.Conta;

import java.math.BigDecimal;
import java.util.Optional;

public class PrincipalOptional {
    public static void main(String[] args) {
        Banco banco = new Banco();

        //busca 1
        banco.buscar(222, 2222)
                .ifPresent(conta -> System.out.println(conta.getTitular()));

        //busca 2
        var conta = banco.buscar(222, 2222)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        System.out.println(conta.getTitular());

        //busca 3
        BigDecimal saldo = banco.buscar(222, 2222)
                .map(Conta::getSaldo)
                .orElse(BigDecimal.ZERO);

        System.out.println(saldo);
    }
}
