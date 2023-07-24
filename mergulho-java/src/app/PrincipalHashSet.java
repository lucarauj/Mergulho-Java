package app;

import modelo.Pessoa;

import java.util.HashSet;
import java.util.Set;

public class PrincipalHashSet {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa("Marcos", "3060120");
        Pessoa p2 = new Pessoa("Maria", "001762");
        Pessoa p3 = new Pessoa("Maria", "001762");

        Set<Pessoa> pessoaList = new HashSet<>();
        pessoaList.add(p1);
        pessoaList.add(p2);
        pessoaList.add(p3);

        System.out.println(pessoaList.toString());

        for (Pessoa pessoa : pessoaList) {
            System.out.println(pessoa.getNome());
        }

        boolean pessoaExiste = pessoaList.contains(p1);
        System.out.println(pessoaExiste);
        System.out.println("Pessoa 1 é igual à pessoa 4? " + (p2.equals(p3) ? "SIM" : "NÃO")); //compara conteúdo
        System.out.println("Pessoa 1 é igual à pessoa 4? " + ((p2 == p3) ? "SIM" : "NÃO")); //compara instância
    }
}
