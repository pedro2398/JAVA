package model;
import java.util.Scanner;

public class Postagem {

	private String textPub;
	private Integer curtida;
	private Empresa empresa;
	
	public String getTextPub() {
		return textPub;
	}
	public void setTextPub(String textPub) {
		this.textPub = textPub;
	}
	public Integer getCurtida() {
		return curtida;
	}
	public void setCurtida(Integer curtida) {
		this.curtida = curtida;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Postagem() {
	}

	public Postagem(String textPub, Integer curtida, Empresa empresa) {
		this.textPub = textPub;
		this.curtida = curtida;
		this.empresa = empresa;
	}
	
	public void curtirPostagem() {
		setCurtida(getCurtida() + 1);
	}
	
	public void publicarPostagem(String text) {
		setTextPub(text);
	}
	
}
