package br.com.exemplo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.exemplo.beans.Usuario;

public class UsuarioDAO {
	private Connection con = Conexao.getConnection();
	
	public void cadastro (Usuario usuario) {
		
		String sql = "INSERT INTO USUARIO (nome, email, senha) values (?, ?, ?)";
			PreparedStatement prepared;
			try {
				prepared = con.prepareStatement(sql);
				prepared.setString(1, usuario.getNome());
				prepared.setString(2, usuario.getEmail());
				prepared.setString(3, usuario.getSenha());
				
				prepared.execute();
				prepared.close();

				System.out.println("Usuário cadastrado com sucesso!");
				
			} catch (SQLException e) {
				
				System.out.println(e);
			}
			
	}
}
