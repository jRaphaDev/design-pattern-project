#Pattern Builder: _DRAFT_

A definição oficial do padrão Builder é: 
_“O Padrão Builder fornece a separação da construção de um objeto complexo da sua representação, de forma que o mesmo processo de construção possa criar diferentes representações.”._


### Caso de Uso
##### Pessoa


No exemplo abaixo vamos criar as classes Pessoa e Enderecamento 
A classe Endereco com atributos referentes ao cadastro de um endereço.
A classe Pessoa como atributos nome, sobrenome, dataNascimento. 
Além destes, o atributo endereco, correspondente a classe Endereco.    
    
    public class Pessoa {
    
        private String nome;
        private String sobrenome;
        private LocalDate dataNascimento;
        private Endereco endereco;
        private List<Telefone> telefones;
    
        public Pessoa() {
        }
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public String getSobrenome() {
            return sobrenome;
        }
    
        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }
    
        public LocalDate getDataNascimento() {
            return dataNascimento;
        }
    
        public void setDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
        }
    
        public Endereco getEndereco() {
            return endereco;
        }
    
        public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
        }
    
        public List<Telefone> getTelefones() {
            return telefones;
        }
    
        public void setTelefones(List<Telefone> telefones) {
            this.telefones = telefones;
        }
    
        @Override
        public String toString() {
            return "Pessoa{" +
                    "nome='" + nome + '\'' +
                    ", sobrenome='" + sobrenome + '\'' +
                    ", dataNascimento=" + dataNascimento +
                    ", endereco=" + endereco +
                    ", telefones=" + telefones +
                    '}';
        }
    }


##### Sem Builder

Vamos criar um objeto Pessoa a partir da classe Pessoa. 
Como se pode notar, é necessário criar uma instancia para a classe Pessoa e outra para a classe Endereco.
Parte da complexidade do código apresentado é a necessidade de se criar uma instancia para cada objeto.
Isto faz com que varias linhas de códigos sejam necessárias.


    public class Application {
    
        public static void main(String[] args) {
    
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("Raphael");
            pessoa.setSobrenome("Freitas");
            pessoa.setDataNascimento(LocalDate.of(1990, Month.AUGUST, 28));
    
            Endereco endereco = new Endereco();
            endereco.setLogradouro("Rua daos segredos");
            endereco.setNumero("777");
            endereco.setCidade("Ilhabela");
            endereco.setBairro("Paraiso");
            endereco.setPais("Brasil");
    
            pessoa.setEndereco(endereco);
    
            List<Telefone> telefones = new ArrayList<>();
    
            Telefone residencial = new Telefone(51, 32221236, Telefone.TipoFone.RESIDENCIAL);
    
            Telefone celular = new Telefone(51, 99623632, Telefone.TipoFone.CELULAR);
    
            telefones.add(residencial);
            telefones.add(celular);
    
            pessoa.setTelefones(telefones);
    
            System.out.println("criado objeto pessoa atraves do builder " + pessoa.toString());
        }
    }
    
    
##### Sem Builder

Usando o padrão Builder podemos facilitar a criação de um objeto pessoa, deixando que as instancias das classes envolvidas, assim como, 
a lista de telefones sejam criadas em um ponto central, que é a classe PessoaBuilder.
 
O método construtor da classe PessoaBuilder cria uma instancia para os objetos Pessoa, Endereco e também para a lista de telefones ( java.util.List ).
O método estático builder() retorna uma instancia para a classe PessoaBuilder. 

Os métodos como nome iniciados por add(), como addNome(), recebem como argumento o valor a ser inserido no objeto e estes métodos retornam a instancia atual de PessoaBuilder, 
criadas ou pelo método builder() ou por new PessoaBuilder().

    public class Application {
    
        public static void main(String[] args) {
    
        Pessoa pessoa = PessoaBuilder.builder()
            .comNome("Raphael ", "Freitas")
            .comDataNascimento(LocalDate.of(1990, Month.AUGUST, 28))
            .comLogradouro("Rua dos segredos")
            .comNumero("777")
            .comBairro("Paraiso")
            .comCidade("Ilhabela")
            .comPais("Brasil")
            .addFone(11, 99999999, Telefone.TipoFone.RESIDENCIAL)
            .addFone(11, 999999999, Telefone.TipoFone.CELULAR)
            .build();
    
            System.out.println("criado objeto pessoa atraves do builder " + pessoa.toString());
        }
    }