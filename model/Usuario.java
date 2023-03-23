package model;

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

	public Usuario(String nome, Calendario calendario) {
		this.nome = nome;
		this.calendario = calendario;
	}

}
