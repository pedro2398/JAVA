package br.com.fiap.resource;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import br.com.fiap.dao.PostagemDAO;
import br.com.fiap.to.PostagemTO;

@Path("/postagem")
public class PostagemResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String exibir() throws SQLException {
		
		PostagemDAO dao = new PostagemDAO();
		List<PostagemTO> postagens = dao.exibir();
		String postagemString = "";
		String post;
		
		for(PostagemTO postagem : postagens) {
			post = "";
			post = "Legenda: " + postagem.getLegenda()+ " - Midia: " + postagem.getMidia() + "\n";
			postagemString = postagemString + post;
		}
		
		postagens.clear();
		
		return postagemString ;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String auth(PostagemTO postagem) throws ClassCastException, SQLException {
		
		PostagemDAO dao = new PostagemDAO();
		
		dao.postar(postagem);
		
		return "Postado!";
		
	}

	
}
