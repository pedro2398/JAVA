package Model;

import java.io.IOException;
import java.util.ArrayList;

import Service.CNPJ_Service;
import Service.testAPI;


public class Empresa extends Usuario{

    private String cnpj;
    private String razaoSocial;
    private ArrayList<Postagem> postagens;
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
        return postagens;
    }
    public void addPostagem(Postagem postagem) {
        this.postagens.add(postagem);
    }
    public ArrayList<Cliente> getClienteInteresse() {
        return clienteInteresse;
    }
    public void addClienteInteresse(Cliente clienteInteresse) {
        this.clienteInteresse.add(clienteInteresse);
    }

    public Empresa() {
    }

    public Empresa(String cnpj, String nome, String razaoSocial) {
        super(nome);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.postagens = new ArrayList<Postagem>();
        this.clienteInteresse = new ArrayList<Cliente>();
    }
    
    public String verStatus() {
    	try {
            CNPJ_Service cnpj_Service = new CNPJ_Service();
            
            testAPI testapi = cnpj_Service.getStatusCNPJ(this.cnpj);
            
            return testapi.getSTATUS().toString();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
            
        } 
    	
    }
    
    public void mostrarFeed(){
    	for(Postagem postagem : this.postagens){
    	System.out.println(postagem.getTextPub());
    	System.out.println("Curtidas: " + postagem.getCurtidas().size());
    	System.out.println();
    	}
    	}
}