package model;
import java.time.LocalDate;

public class Carterinha {
    private String numero;
    private LocalDate validade;


    public Carterinha(String numero, LocalDate validade) {
        this.numero = numero;
        this.validade = validade;
    }


    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getValidade() {
        return this.validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }


}
