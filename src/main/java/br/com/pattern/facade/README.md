# Pattern Facade

A definição oficial do padrão Facade é: 
_“O Padrão Facade fornece uma interface unificada para um conjunto de interfaces em um subsistema. O Facade define uma interface de nível mais alto que facilita a utilização do subsistema”._



### Caso de Uso
##### Computador


No exemplo abaixo podemos notar a quantidade de classes e métodos envolvidos quando precisamos inicializar o computador.
Toda essa complexidade é exposta ao cliente que poderia chamar todas essas classes e cada um dos métodos das classes para realizar a tarefa de inicializar o computador. 
    
    public class Cpu {
    
        public void start() {
            System.out.println("inicialização inicial");
        }
        public void execute() {
            System.out.println("executa algo no processador");
        }
    }
    
    public class HardDrive {
    
        public void read() {
            System.out.println("lê dados do HD");
        }
    }
    
    public class Memoria {
    
        public void load() {
            System.out.println("carrega dados na memória");
        }
    }

No entanto, ao usar uma Facade encapsulamos essa complexidade oferecendo uma interface simples e unificada ao cliente evitando acoplamento e complexidade. 
Apenas chamando o método ligar() da classe ComputadorFacade tem-se uma interface simples que diz o que ela faz exatamente, sem expor a complexidade envolvida na operação.

    package br.com.pattern.facade;
    
    public class Application {
    
        public static void main(String[] args) {
            ComputadorFacade computador = new ComputadorFacade();
            computador.ligar();
        }
    }

    public class ComputadorFacade {
    
        private Cpu cpu;
        private HardDrive hardDrive;
        private Memoria memoria;
    
        public ComputadorFacade() {
            this.cpu = new Cpu();
            this.hardDrive = new HardDrive();
            this.memoria = new Memoria();
        }
    
        public void ligar() {
            cpu.start();
            hardDrive.read();
            memoria.load();
            cpu.execute();
        }
    }