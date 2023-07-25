package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {

    private List<Conta> contas = new ArrayList<>();

    public Banco() {

        Pessoa p1 = new Pessoa("João das Neves", "123321");
        Pessoa p2 = new Pessoa("Maria das Cove", "321123");

        Conta conta1 = new ContaInvestimento(p1, 111, 1111);
        Conta conta2 = new ContaInvestimento(p2, 333, 3333);
        Conta conta3 = new ContaEspecial(p1, 222, 2222, new BigDecimal("1000"));
        Conta conta4 = new ContaEspecial(p2, 444, 4444, new BigDecimal("2000"));

        conta1.depositar(new BigDecimal("100"));
        conta2.depositar(new BigDecimal("200"));
        conta3.depositar(new BigDecimal("300"));
        conta4.depositar(new BigDecimal("400"));

        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);
        contas.add(conta4);

    }

    public List<Conta> getContas() {
        return contas;
    }
    
    public Optional<Conta> buscar(int agencia, int numeroConta) {
        for(Conta conta : getContas()) {
            if(conta.getAgencia() == agencia && conta.getNumero() == numeroConta) {
                return Optional.of(conta);
            }
        }
        return Optional.empty();
    }



}
