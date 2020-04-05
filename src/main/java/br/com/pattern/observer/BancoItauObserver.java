package br.com.pattern.observer;

public class BancoItauObserver implements Observer {
    private Subject subject;

    public BancoItauObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update(Object menssagem) {
        System.out.println("Banco Itau recebeu a menssagem: " + menssagem);

    }
}
