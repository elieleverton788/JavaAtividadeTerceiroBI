package model;

public class UsuarioVip extends Usuario {
    private double descontoMulta;

    public UsuarioVip(int id, String nome, String email, Carterinha carteira, double descontoMulta) {
        super(id, nome, email, carteira);
        this.descontoMulta = descontoMulta;
    }

    
    public double getDescontoMulta() { return descontoMulta; }
    public void setDescontoMulta(double descontoMulta) { this.descontoMulta = descontoMulta; }

    @Override
    public void adicionarEmprestimo(Livro livro) {
        if(livro.isDisponivel()) {
            livro.emprestar();
        } else {
            System.out.println("Livro indisponível.");
        }
    }

    @Override
    public void devolverLivro(Livro livro) {
        livro.devolver();
    }

    public void metodo(byte p) {
        System.out.println("Método polimórfico com parâmetro: " + p);
    }
}

