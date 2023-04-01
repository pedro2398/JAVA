package Model;
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

    public void addEmpresaInteresse(Empresa empresaInteresse) {
        this.empresaInteresse.add(empresaInteresse);
    }

    public Cliente() {
    }

    public Cliente(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
        this.empresaInteresse = new ArrayList<Empresa>();
    }
}