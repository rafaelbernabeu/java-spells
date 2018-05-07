package br.bernabeu;

public class Pessoa {

    private String nome;
    private Integer idade;

    private Pessoa(){}

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
        return new Pessoa.PessoaBuilder(new Pessoa());
    }
    
    public static class PessoaBuilder {
        private Pessoa p;

        private PessoaBuilder(Pessoa p) {
            this.p = p;
        }
        public PessoaBuilder nome(String n) {
           p.nome = n; return new PessoaBuilder(p) ;
        }
        public PessoaBuilder idade(Integer i) {
            p.idade = i; return new PessoaBuilder(p);
        }
        public Pessoa build() { return p; }

    }

}
