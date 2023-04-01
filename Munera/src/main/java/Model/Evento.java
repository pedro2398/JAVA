package Model;

import java.time.LocalDate;

public class Evento {
    private String nome;
    private LocalDate data;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public Evento() {
    }

    public Evento(String nome, LocalDate data) {
        this.nome = nome;
        this.data = data;
    }
}