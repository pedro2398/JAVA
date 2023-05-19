package Service;

import com.google.gson.annotations.SerializedName;

public class testAPI {

	private String STATUS;
	@SerializedName("RAZAO SOCIAL") private String razaoSocial;
	@SerializedName("NOME FANTASIA") private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRAZAO_SOCIAL() {
		return razaoSocial;
	}

	public void setRAZAO_SOCIAL(String rAZAO_SOCIAL) {
		razaoSocial = rAZAO_SOCIAL;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	
}
