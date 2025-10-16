package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoController {
    private List<Emprestimo> emprestimos;

    public EmprestimoController() {
        this.emprestimos = new ArrayList<>();
    }

    public void realizarEmprestimo(Usuario usuario, Livro livro) {
        if(!livro.isDisponivel()) {
            System.out.println("Livro indisponível para empréstimo!");
            return;
        }
        usuario.adicionarEmprestimo(livro);
        Emprestimo emprestimo = new Emprestimo(emprestimos.size() + 1, livro, usuario);
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo registrado: " + livro.getTitulo() + " para " + usuario.getNome());
    }

    public void devolverLivro(Emprestimo emprestimo) {
        emprestimo.devolver();
        System.out.println("Livro devolvido: " + emprestimo.getLivro().getTitulo());
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }
}

