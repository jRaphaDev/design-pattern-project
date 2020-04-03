package br.com.pattern.builder;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

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

        List<Telefone> telefones = new ArrayList<>();

        Telefone residencial = new Telefone(51, 32221236, Telefone.TipoFone.RESIDENCIAL);

        Telefone celular = new Telefone(51, 99623632, Telefone.TipoFone.CELULAR);

        telefones.add(residencial);
        telefones.add(celular);

        pessoa.setTelefones(telefones);

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
                .addFone(11, 99999999, Telefone.TipoFone.RESIDENCIAL)
                .addFone(11, 999999999, Telefone.TipoFone.CELULAR)
                .build();

        System.out.println("criado objeto pessoa atraves do builder " + pessoa.toString());
    }
}