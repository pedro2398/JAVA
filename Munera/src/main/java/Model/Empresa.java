package Model;

import java.util.ArrayList;

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
}