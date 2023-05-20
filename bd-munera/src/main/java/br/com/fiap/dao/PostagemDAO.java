package br.com.fiap.dao;

import br.com.fiap.to.PostagemTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.conexoes.ConexaoFactory;

public class PostagemDAO {

	public void postar(PostagemTO postagem) throws SQLException {
		
		Connection conn = ConexaoFactory.getConnection();
		Statement statement;
		
		try {
			String query = String.format("insert into postagem (ID_POSTAGEM, LEGENDA, MIDIA) values (%s, '%s', '%s')", 1233, postagem.getLegenda(), postagem.getMidia());
			
			statement = conn.createStatement();
			statement.executeUpdate(query);
		
		} catch (Exception e) {
			
			System.out.print("Erro ao postar! - " + e);
		
		} finally {
			
			conn.close();
			
		}
	}
	
	public List<PostagemTO> exibir() throws SQLException {
		List<PostagemTO> postagens = new ArrayList<PostagemTO>();
		Connection conn = ConexaoFactory.getConnection();
		Statement statement;
		
		try {
			
			String query = String.format("select * from postagem");
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				
				PostagemTO postagem = new PostagemTO();
				postagem.setLegenda(rs.getString(3));
				
				String rsFormatado = rs.getBinaryStream(4).toString();
				
				postagem.setMidia(rsFormatado);
				
				postagens.add(postagem);
			}
			
			
		} catch (Exception e) {
			
			System.out.print("Erro ao exibir! - " + e);
		
		} finally {
			
			conn.close();
			
		}
		
		return postagens;
		
	}
}
