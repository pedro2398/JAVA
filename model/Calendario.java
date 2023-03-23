package model;
import java.util.ArrayList;

public class Calendario {

	private ArrayList<Evento> evento;

	public ArrayList<Evento> getEvento() {
		return evento;
	}

	public void setEvento(ArrayList<Evento> evento) {
		this.evento = evento;
	}
	
	public Calendario() {
	}
	
	public Calendario(ArrayList<Evento> evento) {
		this.evento = evento;
	}
	
}
