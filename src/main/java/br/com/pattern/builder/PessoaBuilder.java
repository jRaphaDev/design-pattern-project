package br.com.pattern.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaBuilder {

    private Pessoa pessoa;
    private Endereco endereco;
    private List<Telefone> telefones;


    public PessoaBuilder() {
        this.pessoa = new Pessoa();
        this.endereco = new Endereco();
        this.telefones = new ArrayList<>();
    }

    public static PessoaBuilder builder() {
        return new PessoaBuilder();
    }

    public PessoaBuilder comNome(String nome, String sobrenome) {
        this.pessoa.setNome(nome);
        this.pessoa.setSobrenome(sobrenome);
        return this;
    }

    public PessoaBuilder comDataNascimento(LocalDate dataNascimento) {
        this.pessoa.setDataNascimento(dataNascimento);
        return this;
    }

    public PessoaBuilder comLogradouro(String logradouro) {
        this.endereco.setLogradouro(logradouro);
        return this;
    }

    public PessoaBuilder comNumero(String numero) {
        this.endereco.setNumero(numero);
        return this;
    }

    public PessoaBuilder comComplemento(String complemento) {
        this.endereco.setComplemento(complemento);
        return this;
    }

    public PessoaBuilder comBairro(String bairro) {
        this.endereco.setBairro(bairro);
        return this;
    }

    public PessoaBuilder comCidade(String cidade) {
        this.endereco.setCidade(cidade);
        return this;
    }


    public PessoaBuilder comPais(String pais) {
        this.endereco.setPais(pais);
        return this;
    }

    public PessoaBuilder addFone(int ddd, int numero, Telefone.TipoFone tipoFone) {
        this.telefones.add(new Telefone(ddd, numero, tipoFone));
        return this;
    }

    public Pessoa build(){
        this.pessoa.setEndereco(this.endereco);
        this.pessoa.setTelefones(this.telefones);
        return this.pessoa;
    }



}
