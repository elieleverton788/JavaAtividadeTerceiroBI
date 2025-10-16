package model;



public class Livro {

    private String Titulo;
    private String Autor;
    private boolean disponivel;


    public Livro(String Titulo, String Autor, boolean disponivel) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.disponivel = disponivel;
    }

       public Livro(String Titulo, String Autor) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.disponivel = true;
    }


    public String getTitulo() {
        return this.Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return this.Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public boolean getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void emprestar(){
        if(disponivel){
            disponivel = false;
            System.err.println("emprestada com sucesso");

        }else{
            System.err.println(Titulo +"Livro indisponivel");
        }
    }

    public void devolver(){
        disponivel = true;
        System.err.println(Titulo+"Devolvido com sucesso");
    }
}