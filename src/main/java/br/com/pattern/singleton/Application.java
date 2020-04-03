package br.com.pattern.singleton;

public class Application {

    public static void main(String[] args) {
        System.out.println("chamando a instancia de conexao, dever criar uma nova");
        Connection connection = ConnectionSigleton.getInstance().getConnection();
        connection.create();

        System.out.println("chamando a instancia de conexao, nao deve criar instancia");
        Connection connectionExistente = ConnectionSigleton.getInstance().getConnection();
        connectionExistente.create();
    }
}
