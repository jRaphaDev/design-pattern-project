package br.com.pattern.observer;

public class BancoSantanderObserver implements Observer {
    private Subject subject;

    public BancoSantanderObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update(Object menssagem) {
        System.out.println("Banco Santander recebeu a menssagem: " + menssagem);

    }
}
