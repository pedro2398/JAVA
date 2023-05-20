package br.com.fiap.to;

public class PostagemTO {

	private String legenda;
	private String midia;
	
	public String getLegenda() {
		return legenda;
	}
	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}
	public String getMidia() {
		return midia;
	}
	public void setMidia(String midia) {
		this.midia = midia;
	}

	public PostagemTO() {
		
	}
	
	public PostagemTO(String legenda, String midia) {
		this.legenda = legenda;
		this.midia = midia;
	}
	
}
