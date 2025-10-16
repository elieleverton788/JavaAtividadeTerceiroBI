package model;

public abstract class Usuario {
    protected int id;
    protected String nome;
    protected String email;
    protected Carterinha carteira;


    public Usuario(int id, String nome, String email, Carterinha carteira) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.carteira = carteira;
    }
   


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Carterinha getCarteira() {
        return this.carteira;
    }

    public void setCarteira(Carterinha carteira) {
        this.carteira = carteira;
    }

    public abstract void adicionarEmprestimo(Livro livro);
    public abstract void devolverLivro(Livro livro);

}
