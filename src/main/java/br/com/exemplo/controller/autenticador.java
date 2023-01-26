package br.com.exemplo.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


import br.com.exemplo.beans.Usuario;
import br.com.exemplo.jdbc.UsuarioDAO;

/**
 * Servlet implementation class autenticador
 */
@WebServlet("/autenticador")
public class autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public autenticador() {
        super();
       
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws jakarta.servlet.ServletException, IOException {
    	HttpSession sessao = request.getSession(false);
    	if (sessao!=null) {
			sessao.invalidate();
		}
			response.sendRedirect("login.jsp");
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws jakarta.servlet.ServletException, IOException {
		
		String semail = request.getParameter("email");
    	String ssenha = request.getParameter("senha");
    	
    	Usuario usu = new Usuario();
    	usu.setEmail(semail);
    	usu.setSenha(ssenha);
    	
    	UsuarioDAO usuDao = new UsuarioDAO();
    	Usuario usuAutenticado = usuDao.autenticacao(usu);
    	
    	if (usuAutenticado != null ) {
    		
    		HttpSession sessao = request.getSession();
    		sessao.setAttribute("usuAutenticado", usuAutenticado);
    		
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			
			response.sendRedirect("erroLogin.jsp");
		}
	}

}
