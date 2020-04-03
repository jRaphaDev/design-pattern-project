package br.com.pattern.singleton;

public class ConnectionSigleton {

    private static final ConnectionSigleton instanciaUnica = new ConnectionSigleton();
    private static Connection connection;

    private ConnectionSigleton(){
        connection = new ConnectionFactory().criarConexao();
        System.out.println("instancia criada.");
    }

    public static Connection getConnection(){
        return connection;
    }
}
