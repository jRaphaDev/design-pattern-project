package br.com.pattern.observer;

public class Application {

    public static void main(String[] args) {

        BancoCentralSubject bancoCentral = new BancoCentralSubject();
        adicionarTodosObservers(bancoCentral);

        Object menssagem = "essa é a menssagem enviada";
        bancoCentral.enviarMenssagemParaOutrosBancos(menssagem);
    }

    private static void adicionarTodosObservers(BancoCentralSubject bancoCentral){
        new BancoSantanderObserver(bancoCentral);
        new BancoBradescoObserver(bancoCentral);
        new BancoItauObserver(bancoCentral);
    }
}
