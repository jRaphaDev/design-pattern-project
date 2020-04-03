# Pattern Facade

A definição oficial do padrão Facade é: 
_“O Padrão Facade fornece uma interface unificada para um conjunto de interfaces em um subsistema. O Facade define uma interface de nível mais alto que facilita a utilização do subsistema”._



### Caso de Uso
##### Computador

 
    package br.com.pattern.facade;
    
    public class Application {
    
        public static void main(String[] args) {
            ComputadorFacade computador = new ComputadorFacade();
            computador.ligar();
        }
    
    }
