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
