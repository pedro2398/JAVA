package model;

import java.util.ArrayList;

public class Empresa extends Usuario{

	private String cnpj;
	private String razaoSocial;
	private ArrayList<Postagem> postagem;
	private ArrayList<Cliente> clienteInteresse;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public ArrayList<Postagem> getPostagem() {
		return postagem;
	}
	public void setPostagem(ArrayList<Postagem> postagem) {
		this.postagem = postagem;
	}
	public ArrayList<Cliente> getClienteInteresse() {
		return clienteInteresse;
	}
	public void setClienteInteresse(ArrayList<Cliente> clienteInteresse) {
		this.clienteInteresse = clienteInteresse;
	}
	
	public Empresa() {
	}
	
	public Empresa(String cnpj, String nome, String razaoSocial, Calendario calendario, ArrayList<Postagem> postagem, ArrayList<Cliente> clienteInteresse) {
		super(nome, calendario);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.postagem = postagem;
		this.clienteInteresse = clienteInteresse;
	}
}
