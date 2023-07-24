package app;

import modelo.Banco;
import modelo.Conta;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PrincipalStreams {

    public static void main(String[] args) {

        Banco banco = new Banco();

        //stream1
        banco.getContas().stream()
                .filter(conta -> conta.getSaldoDisponivel().compareTo(new BigDecimal("100")) > 0)
                .filter(conta -> conta.getNumero() > 2000)
                .sorted(Comparator.comparingInt(Conta::getNumero))
                .forEach(conta -> {
                    System.out.println(conta.getTitular() + "/" + "Conta: " + conta.getNumero() + " - " + "Agência: " + conta.getAgencia());
                });

        //stream2 - transformando conta em titular
        banco.getContas().stream()
                .filter(conta -> conta.getSaldoDisponivel().compareTo(new BigDecimal("100")) > 0)
                .filter(conta -> conta.getNumero() > 2000)
                .map(Conta::getTitular)
                .distinct() //não repete objetos baseado no método equals
                .forEach(System.out::println);

        //stream3 - somando valores
        var saldoTotal = banco.getContas().stream()
                .map(Conta::getSaldo)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(saldoTotal);

        //stream4 - transformando Conta em Pessoa e Pessoa em lista
        banco.getContas().stream()
                .map(Conta::getTitular)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}