# Pattern Singleton: DRAFT

O Padrão Singleton garante: _“a existência de apenas uma instância de uma classe, mantendo um ponto global de acesso ao seu objeto.”_


### Caso de Uso
##### Conexao com banco de dados


No exemplo abaixo podemos ver um exemplo de criacao de uma classe que abre uma concexao com banco de dados

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

Executando metódo de criacao duas vezes de uma instancia unica ...

    public class Application {
    
        public static void main(String[] args) {
            System.out.println("chamando a instancia de conexao, dever criar uma nova");
            Connection connection = ConnectionSigleton.getConnection();
            connection.create();
    
            System.out.println("chamando a instancia de conexao, nao deve criar instancia");
            Connection connectionExistente = ConnectionSigleton.getConnection();
            connectionExistente.create();
        }
    }
    
Com isso a responsta que temos é ....

    chamando a instancia de conexao, dever criar uma nova
    criando conexao ...
    instancia criada.
    objeto criado com sucesso.
    chamando a instancia de conexao, nao deve criar instancia
    objeto criado com sucesso.
    