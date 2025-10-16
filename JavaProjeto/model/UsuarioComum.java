package model;

public class UsuarioComum extends Usuario {
    private int limiteLivros = 3;

    public UsuarioComum(int id, String nome, String email, Carterinha carteira) {
        super(id, nome, email, carteira);
    }

    
    public int getLimiteLivros() {
        return limiteLivros;
    }

    public void setLimiteLivros(int limiteLivros) {
        this.limiteLivros = limiteLivros;
    }

    @Override
    public void adicionarEmprestimo(Livro livro) {
        if(limiteLivros > 0 && livro.isDisponivel()) {
            livro.emprestar();
            limiteLivros--;
        } else {
            System.out.println("Não é possível emprestar o livro.");
        }
    }

    @Override
    public void devolverLivro(Livro livro) {
        livro.devolver();
        limiteLivros++;
    }
}
