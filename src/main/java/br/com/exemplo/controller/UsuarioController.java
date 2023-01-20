package br.com.exemplo.controller;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws jakarta.servlet.ServletException,IOException{
		Usuario usu = new Usuario();
		UsuarioDAO usuDao = new UsuarioDAO();
		
		List<Usuario> list = usuDao.searchAll(usu);
        request.setAttribute("list", list);
        RequestDispatcher saida = request.getRequestDispatcher("listaUsu.jsp");
        saida.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
		
		doGet(request, response);
	}


}
