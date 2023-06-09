package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.to.EmpresaTO;

@Path("/empresas")
public class EmpresaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String exibir() throws SQLException {
		EmpresaDAO dao = new EmpresaDAO();
		List<EmpresaTO> empresas = dao.exibir();
		
		JSONArray jsonEmpresas = new JSONArray();
		
		for (EmpresaTO empresa : empresas) {
			JSONObject jsonEmpresa = new JSONObject();
			jsonEmpresa.put("id", empresa.getId_empresa());
			jsonEmpresa.put("cnpj", empresa.getCnpj());
			jsonEmpresa.put("nome", empresa.getNome());
			jsonEmpresa.put("email", empresa.getEmail());
			jsonEmpresa.put("senha", empresa.getSenha());
			jsonEmpresa.put("segmento", empresa.getSegmento());
			
			jsonEmpresas.put(jsonEmpresa);
		}
		
		return jsonEmpresas.toString();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void post(EmpresaTO empresa) throws SQLException {
		
		try {
			EmpresaDAO dao = new EmpresaDAO();
			dao.inserir(empresa);
		} catch (Exception e) {
			System.out.print("Erro - " + e);
		}
		
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") String id) throws SQLException {

		EmpresaDAO dao = new EmpresaDAO();
		dao.deletar(id);
	}
}
