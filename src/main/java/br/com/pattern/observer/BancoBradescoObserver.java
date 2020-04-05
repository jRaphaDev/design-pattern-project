package br.com.pattern.observer;

public class BancoBradescoObserver implements Observer {
    private Subject subject;

    public BancoBradescoObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update(Object menssagem) {
        System.out.println("Banco Bradesco recebeu a menssagem: " + menssagem);

    }
}
