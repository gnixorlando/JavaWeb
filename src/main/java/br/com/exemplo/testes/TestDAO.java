package br.com.exemplo.testes;

import java.util.List;

import br.com.exemplo.beans.Usuario;
import br.com.exemplo.jdbc.UsuarioDAO;

public class TestDAO {
		public static void main(String[] args) {
			testSearchAll();
		}
		public static void testCadastro () {
			Usuario usuario = new Usuario ();
			
			usuario.setNome("João Vitor");
			usuario.setEmail("joaovitor@gmail.com");
			usuario.setSenha("gerencieaqui");
			
			UsuarioDAO usuDao = new UsuarioDAO();
			usuDao.cadastro(usuario);
			
		}
		public static void testEdit () {
			
			Usuario usuario = new Usuario ();
			
			usuario.setId(3);
			usuario.setNome("João Vitor Targino");
			usuario.setEmail("joaovitortargino12@gmail.com");
			usuario.setSenha("gerencieaqui");
			
			
			UsuarioDAO usuDao = new UsuarioDAO();
			usuDao.edit(usuario);
		}
		
		public static void testRemove () {
			Usuario usuario = new Usuario ();
			
			usuario.setId(4);
			
			UsuarioDAO usuDao = new UsuarioDAO();
			usuDao.remove(usuario);
		}
		
		public static void mostrarInformacoes () {
			Usuario usuario = new Usuario ();
			System.out.println (usuario.getId() + usuario.getNome()+usuario.getEmail()+ usuario.getSenha() );
			
			
		}
		public static void testSearchAll () {
			
			Usuario usuario = new Usuario ();
			UsuarioDAO usuDao = new UsuarioDAO();
			
			List<Usuario> listResult = usuDao.searchAll(usuario);
			
			for (Usuario u:listResult) {
				
				System.out.println(" Id: " + u.getId() + " Nome: " + u.getNome() + " Email: " + u.getEmail() + " Senha: " + u.getSenha());
			}
		}
}
