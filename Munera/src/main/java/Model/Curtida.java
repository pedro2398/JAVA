package Model;

public class Curtida {
    private Postagem postagem;
    private Cliente cliente;

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Curtida() {
    }

    public Curtida(Postagem postagem, Cliente cliente) {
        this.postagem = postagem;
        this.cliente = cliente;
    }
}
