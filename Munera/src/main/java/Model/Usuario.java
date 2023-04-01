package Model;

import java.util.ArrayList;

public class Usuario {

    private String nome;
    private Calendario calendario;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendario getCalendario() {
        return calendario;
    }
    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
        this.calendario = new Calendario();
    }

    public void consultarCalendario(){
        Calendario calendario = this.getCalendario();
        ArrayList<Evento> eventos = calendario.getEvento();
        for (Evento evento : eventos){
            System.out.println(evento.getData().toString());
            System.out.println(evento.getNome());
            System.out.println();
        }
    }
}