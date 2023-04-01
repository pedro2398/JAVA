package Model;
import java.util.ArrayList;
import java.util.Scanner;

public class Postagem {

    private String textPub;
    private ArrayList<Curtida> curtidas;
    private Empresa empresa;

    public String getTextPub() {
        return textPub;
    }
    public void setTextPub(String textPub) {
        this.textPub = textPub;
    }

    public ArrayList<Curtida> getCurtidas() {
        return curtidas;
    }

    public void addCurtida(Curtida curtida) {
        this.curtidas.add(curtida);
    }

    public Empresa getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Postagem() {
    }

    public Postagem(String textPub, Empresa empresa) {
        this.textPub = textPub;
        this.empresa = empresa;
        this.curtidas = new ArrayList<Curtida>();
    }

    //Método relevante
    public void curtirPostagem(Cliente cliente) {
        Curtida curtida = new Curtida(this, cliente);
        this.curtidas.add(curtida);
    }

}