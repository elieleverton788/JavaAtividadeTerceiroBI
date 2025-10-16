package model;

public class Gerente {
    private String nome;
    private String cpf;


    public Gerente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void gerarRelatorio(){
        System.err.println("Gerando relatorio da blioteca...");
    }
}
