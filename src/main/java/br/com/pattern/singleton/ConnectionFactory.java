package br.com.pattern.singleton;

public class ConnectionFactory {

    public Connection criarConexao(){
        System.out.println("criando conexao ...");
        return new Connection();
    }
}
