package br.com.pattern.strategy;

public class Venda {

    private double valorVenda;
    private Funcionario funcionario;

    public Venda(double valorVenda, Funcionario funcionario) {
        this.valorVenda = valorVenda;
        this.funcionario = funcionario;
    }

    public double calculaComissao() {
        final double valorComissao = this.funcionario.getCargo().calcularComissao(this.valorVenda);

        return valorComissao;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
