package br.com.pattern.strategy;

public class VendaBuilder {

    private double valorVenda;
    private Funcionario funcionario;

    public VendaBuilder() {
        funcionario = new Funcionario();
    }

    public static VendaBuilder builder() {
        return new VendaBuilder();
    }


    public VendaBuilder comValorDeVenda(double valorVenda){
        this.valorVenda = valorVenda;
        return this;
    }

    public VendaBuilder comCargo(Strategy cargo){
        this.funcionario.setCargo(cargo);
        return this;
    }

    public Venda build() {
        return new Venda(valorVenda, funcionario);
    }



}
