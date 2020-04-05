# Pattern Strategy
O Padrão Strategy garante: _“.....”_


### Caso de Uso
##### Calculo de comissao de venda para destintos funcionarios

No exemplo abaixo podemos....

    package br.com.pattern.strategy;
    
    public enum Cargo implements Strategy {
        ATENDENTE {
            @Override
            public double calcularComissao(double valorVenda) {
                return (valorVenda * 0.01);
            }
        },
        VENDEDOR {
            @Override
            public double calcularComissao(double valorVenda) {
                return (valorVenda * 0.02);
            }
        },
        GERENTE {
            @Override
            public double calcularComissao(double valorVenda) {
                return (100 + valorVenda * 0.03);
            }
        };
    }
    
    public interface Strategy {
        double calcularComissao(double valorCompra);
    }
    
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
    }

Executando o metódo .........:

    cpublic class Application {
     
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
    
Temos com saída:
        
    Comissao de um atendente: 2000.0
    Comissao de um gerente: 6100.0
    Comissao de um vendedor: 4000.0