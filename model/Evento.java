package model;

public class Evento {
	private String nome;
	private String data;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public Evento() {
	}

	public Evento(String nome, String data) {
		this.nome = nome;
		this.data = data;
	}
}
