package br.com.pattern.strategy;

public class Application {


    public static void main(String[] args){

        Venda vendaAtendente = VendaBuilder.builder()
                .comValorDeVenda(200000.0)
                .comCargo(Cargo.ATENDENTE)
                .build();
        System.out.println("Comissao de um atendente: " + vendaAtendente.calculaComissao());


        Venda vendaGerente = VendaBuilder.builder()
                .comValorDeVenda(200000.0)
                .comCargo(Cargo.GERENTE)
                .build();
        System.out.println("Comissao de um gerente: " + vendaGerente.calculaComissao());


        Venda vendaVendedor = VendaBuilder.builder()
                .comValorDeVenda(200000.0)
                .comCargo(Cargo.VENDEDOR)
                .build();
        System.out.println("Comissao de um vendedor: " + vendaVendedor.calculaComissao());
    }
}
