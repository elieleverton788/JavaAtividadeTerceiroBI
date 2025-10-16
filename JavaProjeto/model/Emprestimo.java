package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    
    private int id;
    private LocalDate dataemprestimo;
    private LocalDate dataDevolucao;
    private Livro livro;
    private Usuario usuario;


public Emprestimo(int id, Livro livro, Usuario usuario) {
    this.id = id;
    this.livro = livro;
    this.usuario = usuario;
    this.dataemprestimo = LocalDate.now();
    this.dataDevolucao = null;
}

    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEmprestimo() {
        return this.dataemprestimo;
    }
    public void setDataEmprestimo(LocalDate dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }

    public LocalDate getDataDevolucao() {
        return this.dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Livro getLivro() {
        return this.livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void devolver(){
        this.dataDevolucao = LocalDate.now();
        livro.devolver();
    }

    public long calcularAtraso(){
        if(dataDevolucao == null) return 0;
        long dias = ChronoUnit.DAYS.between(dataemprestimo.plusDays(7), dataDevolucao);
        return dias > 0 ? dias : 0;
    }
}
