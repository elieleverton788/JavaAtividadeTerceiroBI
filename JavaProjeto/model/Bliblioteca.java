package model;
import java.util.List;

public class Bliblioteca {

    private String nome;
    private String endereco;
    private List<Livro> livros;
    private Gerente gerente;


    public Bliblioteca(String nome, String endereco, List<Livro> livros, Gerente gerente) {
        this.nome = nome;
        this.endereco = endereco;
        this.livros = livros;
        this.gerente = gerente;
    }
   

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Livro> getLivros() {
        return this.livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Gerente getGerente() {
        return this.gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public void adicionarLivro(Livro livro){
        livros.add(livro);
        System.err.println("Livro adicionado"+ livro.getTitulo());
    }

    public void cadastrarUsuario(Usuario usuario){
        System.err.println("Usuario cadastrado"+ usuario.getNome());
    
    }

     public void registrarEmprestimo(Emprestimo emprestimo) {
        System.out.println("Empréstimo registrado: " + emprestimo.getLivro().getTitulo() +
        " para " + emprestimo.getUsuario().getNome());
    }
}