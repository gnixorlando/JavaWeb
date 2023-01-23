package br.com.exemplo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;

import br.com.exemplo.beans.Usuario;
import br.com.exemplo.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
@jakarta.servlet.annotation.WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws jakarta.servlet.ServletException, IOException {
		Usuario usu = new Usuario();
		String action = request.getParameter("action");
		UsuarioDAO usuDao = new UsuarioDAO();

		if (action != null && action.equals("lis")) {

			List<Usuario> list = usuDao.searchAll(usu);
			request.setAttribute("list", list);
			RequestDispatcher saida = request.getRequestDispatcher("listaUsu.jsp");
			saida.forward(request, response);

		} else if (action != null && action.equals("del")) {
			String id = request.getParameter("id");
			usu.setId(Integer.parseInt(id));
			usuDao.remove(usu);

			response.sendRedirect("UsuarioController?action=lis");
		} else if (action != null && action.equals("alt")) {
			String id = request.getParameter("id");
			Usuario usuario = usuDao.buscarId(Integer.parseInt(id));
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("alterarCad.jsp").forward(request, response);

		}
		else if (action != null && action.equals("cad")) {
			RequestDispatcher saida = request.getRequestDispatcher("cadastro.jsp");
			saida.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws jakarta.servlet.ServletException, IOException {
		String sid = request.getParameter("id");
		String snome = request.getParameter("nome");
		String semail = request.getParameter("email");
		String ssenha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setNome(snome);
		usuario.setEmail(semail);
		usuario.setSenha(ssenha);
		
		usuario.setId(Integer.parseInt(sid));
		
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.edit(usuario);
		
		PrintWriter out = response.getWriter();
		response.sendRedirect("UsuarioController?action=lis");
		
	}
	
	
}
