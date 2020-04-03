package br.com.pattern.facade;

public class Application {

    public static void main(String[] args) {

        ComputadorFacade computador = new ComputadorFacade();
        computador.ligar();

    }

}
