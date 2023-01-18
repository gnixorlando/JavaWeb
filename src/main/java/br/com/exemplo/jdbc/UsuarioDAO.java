package br.com.exemplo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.beans.Usuario;

public class UsuarioDAO {
	private Connection con = Conexao.getConnection();

	public void cadastro(Usuario usuario) {

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

	public void edit(Usuario usuario) {
		String sql = "UPDATE USUARIO SET NOME = ?, EMAIL = ?,SENHA = ? where id = ?";
		PreparedStatement prepared;
		try {
			prepared = con.prepareStatement(sql);
			prepared.setString(1, usuario.getNome());
			prepared.setString(2, usuario.getEmail());
			prepared.setString(3, usuario.getSenha());
			prepared.setInt(4, usuario.getId());

			prepared.execute();
			prepared.close();

			System.out.println("Usuário alterado com sucesso!");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void remove(Usuario usuario) {
		String sql = "DELETE FROM USUARIO WHERE id = ?";
		PreparedStatement prepared;

		try {
			prepared = con.prepareStatement(sql);
			prepared.setInt(1, usuario.getId());
			
			prepared.execute();
			prepared.close();

			System.out.println("Usuário removido com sucesso!");
		} catch (Exception e) {

			System.out.println(e);
		}
		}

	public List<Usuario> searchAll (Usuario usuario) {
		String sql = "SELECT * FROM USUARIO";
		List<Usuario> list = new ArrayList<Usuario>(); 
		try {
			PreparedStatement prepared =con.prepareStatement(sql);
			ResultSet result = prepared.executeQuery();
			while (result.next()) {
				Usuario usu = new Usuario();
				usu.setId(result.getInt("id"));
				usu.setNome(result.getString("nome"));
				usu.setEmail(result.getString("email"));
				usu.setSenha(result.getString("senha"));
				list.add(usu);
			}
		} catch (Exception e) {
			System.out.println(e);
		} return list;
	}
}
