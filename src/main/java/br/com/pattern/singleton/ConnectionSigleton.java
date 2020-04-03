package br.com.pattern.singleton;

import java.util.UUID;

public class ConnectionSigleton {

    private static ConnectionSigleton unicaInstancia = new ConnectionSigleton();
    private static Connection connection;

    private ConnectionSigleton(){
        connection = new ConnectionFactory().criarConexao();
        System.out.println("instancia criada.");
    }

    public static ConnectionSigleton getInstance() {
        return unicaInstancia;
    }

    public Connection getConnection(){
        return connection;
    }
}
