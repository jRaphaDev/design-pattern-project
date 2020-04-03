package br.com.pattern.builder;

import java.time.LocalDate;
import java.time.Month;

public class Application {

    public static void main(String[] args) {

        criaObjetoPessoa();
        criaObjectoPessoaBuilder();
    }

    private static void criaObjetoPessoa() {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Raphael");
        pessoa.setSobrenome("Freitas");
        pessoa.setDataNascimento(LocalDate.of(1990, Month.AUGUST, 28));

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua das Oliveiras");
        endereco.setNumero("272");
        endereco.setComplemento("Bloco B");
        endereco.setCidade("Porto Alegre");
        endereco.setBairro("Centro");
        endereco.setPais("Brasil");

        pessoa.setEndereco(endereco);

        System.out.println("criado objeto pessoa atraves do builder " + pessoa.toString());
    }

    private static void criaObjectoPessoaBuilder() {
        Pessoa pessoa = PessoaBuilder.builder()
                .comNome("Raphael ", "Freitas")
                .comDataNascimento(LocalDate.of(1990, Month.AUGUST, 28))
                .comLogradouro("Rua das Oliveiras")
                .comNumero("272")
                .comComplemento("Bloco B")
                .comBairro("Centro")
                .comCidade("Porto Alegre")
                .comPais("Brasil")
                .build();

        System.out.println("criado objeto pessoa atraves do builder " + pessoa.toString());
    }
}