# Pattern Observer

O Pattern Observer é um padrāo que: _“define uma dependência um-para-muitos entre objetos de modo que quando um objeto muda o estado, todos seus dependentes são notificados e atualizados automaticamente. Permite que objetos interessados sejam avisados da mudança de estado ou outros eventos ocorrendo num outro objeto.”_

### Caso de Uso
##### Envio de menssagens do Banco Central para Outros bancos com Santander, Itau, Bradesco.

Imagine o caso de uso,cujo o banco central precisa notificar todos os bancos com alguma informacao.

No código abaixo demosntro como sera a classe observadora, ou seja a classe será notificada quando o
banco central enviar a menssagem;

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

    public interface Observer {
        void update( Object menssagem );
    }
    
Agora no código abaixo demosntro como sera a classe responsavel por enviar as menssagens para todos "ouvintes"

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
            observers.stream()
                    .forEach(observer -> observer.update(menssagem));
        }
    }
    
    interface Subject {
        void addObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();
    }


Agora vamos a execucao real do envio da menssagem:

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
    
    Banco Santander recebeu a menssagem: essa é a menssagem enviada
    Banco Bradesco recebeu a menssagem: essa é a menssagem enviada
    Banco Itau recebeu a menssagem: essa é a menssagem enviada
