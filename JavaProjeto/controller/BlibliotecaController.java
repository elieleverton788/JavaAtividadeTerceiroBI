package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class BlibliotecaController {
    private Bliblioteca biblioteca;
    private List<Usuario> usuarios;

    public BlibliotecaController(Bliblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.usuarios = new ArrayList<>();
    }

    public void adicionarLivro(String Titulo, String Autor) {
        Livro livro = new Livro(Titulo, Autor);
        biblioteca.adicionarLivro(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        biblioteca.cadastrarUsuario(usuario);
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();
        for(Livro l : biblioteca.getLivros()) {
            if(l.isDisponivel()) disponiveis.add(l);
        }
        return disponiveis;
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}

