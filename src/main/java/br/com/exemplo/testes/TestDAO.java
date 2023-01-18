package br.com.exemplo.testes;

import br.com.exemplo.beans.Usuario;
import br.com.exemplo.jdbc.UsuarioDAO;

public class TestDAO {
		public static void main(String[] args) {
			testCadastro();
		}
		public static void testCadastro () {
			Usuario usuario = new Usuario ();
			
			usuario.setNome("João Vitor");
			usuario.setEmail("joaovitor@gmail.com");
			usuario.setSenha("gerencieaqui");
			
			UsuarioDAO usuDao = new UsuarioDAO();
			usuDao.cadastro(usuario);
			
		}
}
