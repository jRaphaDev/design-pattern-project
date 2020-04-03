#Pattern Builder: _DRAFT_

A definição oficial do padrão Builder é: 
_“O Padrão Builder fornece ...”._



### Caso de Uso
##### Pessoa


No exemplo abaixo ..... 
    
    
    public class Pessoa {

        private String nome;
        private String sobrenome;
        private LocalDate dataNascimento;
        private Endereco endereco;
    
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
    
        @Override
        public String toString() {
            return "Pessoa{" +
                    "nome='" + nome + '\'' +
                    ", sobrenome='" + sobrenome + '\'' +
                    ", dataNascimento=" + dataNascimento +
                    ", endereco=" + endereco +
                    '}';
        }
    }

Sem Builder

    public class Application {
    
        public static void main(String[] args) {
    
            Pessoa pessoa = new Pessoa();
            pessoa.setNome("Raphael");
            pessoa.setSobrenome("Freitas");
            pessoa.setDataNascimento(LocalDate.of(1990, Month.AUGUST, 28));
    
            Endereco endereco = new Endereco();
            endereco.setLogradouro("Rua das Oliveiras");
            endereco.setNumero("272");
            endereco.setComplemento("Bloco B");
            endereco.setCidade("Porto Alegre");
            endereco.setBairro("Centro");
            endereco.setPais("Brasil");
    
            pessoa.setEndereco(endereco);
    
            System.out.println("criado objeto pessoa atraves do builder " + pessoa.toString());
        }
    }
    
    
Builder

    public class Application {
    
        public static void main(String[] args) {
    
        Pessoa pessoa = PessoaBuilder.builder()
                    .comNome("Raphael ", "Freitas")
                    .comDataNascimento(LocalDate.of(1990, Month.AUGUST, 28))
                    .comLogradouro("Rua das Oliveiras")
                    .comNumero("272")
                    .comComplemento("Bloco B")
                    .comBairro("Centro")
                    .comCidade("Porto Alegre")
                    .comPais("Brasil")
                    .build();
    
            System.out.println("criado objeto pessoa atraves do builder " + pessoa.toString());
        }
    }