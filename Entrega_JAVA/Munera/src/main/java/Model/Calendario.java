package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Calendario {
    private ArrayList<Evento> eventos;

    public ArrayList<Evento> getEvento() {
        return eventos;
    }

    public void addEvento(Evento evento) {
        this.eventos.add(evento);
    }

    public Calendario() {
        this.eventos = new ArrayList<Evento>();
    }
}