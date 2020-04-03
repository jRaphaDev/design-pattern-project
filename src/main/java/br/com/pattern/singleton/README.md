# Pattern Singleton: DRAFT

A definição oficial do padrão Facade é: 
_“O Padrão Singleton fornece ”._


### Caso de Uso
##### Conexao com banco de dados


No exemplo abaixo podemos notar a .....

    public class ConnectionSigleton {
    
        private static ConnectionSigleton unicaInstancia = new ConnectionSigleton();
        private static Connection connection;
    
        private ConnectionSigleton(){
            ConnectionFactory factory = new ConnectionFactory();
    
            this.connection = factory.criarConexao();
    
            System.out.println("instancia criada.");
        }
    
        public static ConnectionSigleton getInstance() {
            return unicaInstancia;
        }
    
        public Connection getConnection(){
            return connection;
        }
    }

Executando metódo de criacao duas vezes de uma instancia unica ...

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
    
Com isso a responsta que temos é ....

    chamando a instancia de conexao, dever criar uma nova
    criando conexao ...
    instancia criada.
    objeto criado com sucesso.
    chamando a instancia de conexao, nao deve criar instancia
    objeto criado com sucesso.
    