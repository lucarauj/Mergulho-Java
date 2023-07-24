package app;

import modelo.Banco;
import modelo.Conta;

import java.util.Comparator;

public class PrincipalLambda {

    public static void main(String[] args) {

        Banco banco = new Banco();

//      ordenação
//      banco.getContas().sort(Comparator.comparingInt(conta -> conta.getNumero()));
        banco.getContas().sort(Comparator.comparingInt(Conta::getNumero));

        for (Conta conta: banco.getContas()) {
            System.out.println(conta.getAgencia() + "/" + conta.getNumero());
        }
    }
}
