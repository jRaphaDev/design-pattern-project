package br.com.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class BancoCentralSubject implements Subject {

    private List<Observer> observers;
    private Object menssagem;

    public BancoCentralSubject() {
        observers = new ArrayList<>();
    }

    public void enviarMenssagemParaOutrosBancos(Object menssagem){
        this.menssagem = menssagem;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if( index > -1 ){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for( Observer o :observers ){
            o.update( menssagem );
        }
    }
}
