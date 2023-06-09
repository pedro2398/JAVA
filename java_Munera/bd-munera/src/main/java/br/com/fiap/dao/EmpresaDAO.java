package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.to.EmpresaTO;

public class EmpresaDAO {

	public List<EmpresaTO> exibir() throws SQLException {
		List<EmpresaTO> empresas = new ArrayList<>();
		
		Connection conn = ConexaoFactory.getConnection();
		Statement statement;
		
		try {
			String query = "SELECT * FROM EMPRESAS";
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				EmpresaTO empresa = new EmpresaTO();
			    empresa.setId_empresa(rs.getInt("ID_EMPRESA"));
			    empresa.setCnpj(rs.getString("CNPJ"));
			    empresa.setNome(rs.getString("NOME"));
			    empresa.setEmail(rs.getString("EMAIL"));
			    empresa.setSenha(rs.getString("SENHA"));
			    empresa.setSegmento(rs.getInt("SEGMENTO"));
			    
			    empresas.add(empresa);
			}
			
		} catch(Exception e) {
			System.out.print("Erro ao exibir! - " + e);
		} finally {
			conn.close();
		}
		
		return empresas;
		
	}
	
	public void inserir(EmpresaTO empresa) throws SQLException {
		Connection conn = ConexaoFactory.getConnection();
		Statement statement;
		
		try {
			
			String query = String.format("INSERT INTO EMPRESAS (ID_EMPRESA, CNPJ, NOME, EMAIL, SENHA, SEGMENTO) VALUES (%s, '%s', '%s', '%s', '%s', %s)",
			empresa.getId_empresa(), empresa.getCnpj(), empresa.getNome(), empresa.getEmail(), empresa.getSenha(), empresa.getSegmento());
			
			statement = conn.createStatement();
			statement.executeUpdate(query);
			
		} catch(Exception e) {
			System.out.print("Erro - " + e);
		}
	}
	
	public void deletar(String id) throws SQLException {

		Connection conn = ConexaoFactory.getConnection();
		Statement statement;

		try {

			String query = String.format("DELETE FROM EMPRESAS WHERE ID_EMPRESA = '%s'", id);

			statement = conn.createStatement();
			statement.executeUpdate(query);
			statement.close();

		} catch (Exception e) {
			System.out.print("Erro - " + e);
		}
	
  }
	
}