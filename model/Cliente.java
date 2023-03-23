package model;
import java.util.ArrayList;

public class Cliente extends Usuario{
	
	private String cpf;
	private ArrayList<Empresa> empresaInteresse;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ArrayList<Empresa> getEmpresaInteresse() {
		return empresaInteresse;
	}

	public void setEmpresaInteresse(ArrayList<Empresa> empresaInteresse) {
		this.empresaInteresse = empresaInteresse;
	}

	public Cliente() {
	}

	public Cliente(String cpf, String nome, Calendario calendario, ArrayList<Empresa> empresaIntresse) {
		super(nome, calendario);
		this.cpf = cpf;
		this.empresaInteresse = empresaIntresse;
	}
}
