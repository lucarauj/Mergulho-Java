package app;

import modelo.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PrincipalArrayList {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa("Marcos", "3060120");
        Pessoa p2 = new Pessoa("Maria", "001762");
        Pessoa p3 = new Pessoa("Maria", "001762");

        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(p1);
        pessoaList.add(p2);
        pessoaList.add(p3);

        System.out.println(pessoaList.toString());
        System.out.println(pessoaList.get(1));

        for (Pessoa pessoa : pessoaList) {
            System.out.println(pessoa.getNome());
        }

        boolean pessoaExiste = pessoaList.contains(p1);
        System.out.println(pessoaExiste);
        System.out.println("Pessoa 1 é igual à pessoa 4? " + (p2.equals(p3) ? "SIM" : "NÃO")); //compara conteúdo
        System.out.println("Pessoa 1 é igual à pessoa 4? " + ((p2 == p3) ? "SIM" : "NÃO")); //compara instância
    }
}
