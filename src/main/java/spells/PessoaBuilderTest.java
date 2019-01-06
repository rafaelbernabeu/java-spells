package spells;

public class PessoaBuilderTest {

    private String nome;
    private Integer idade;

    private PessoaBuilderTest(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public static PessoaBuilder builder() {
        return new PessoaBuilderTest.PessoaBuilder(new PessoaBuilderTest());
    }
    
    public static class PessoaBuilder {
        private PessoaBuilderTest p;

        private PessoaBuilder(PessoaBuilderTest p) {
            this.p = p;
        }
        public PessoaBuilder nome(String n) {
           p.nome = n; return new PessoaBuilder(p) ;
        }
        public PessoaBuilder idade(Integer i) {
            p.idade = i; return new PessoaBuilder(p);
        }
        public PessoaBuilderTest build() { return p; }

    }

}
