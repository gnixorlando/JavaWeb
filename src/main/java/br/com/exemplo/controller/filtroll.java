package br.com.exemplo.controller;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;



/**
 * Servlet Filter implementation class filtroll
 */
@WebFilter("/*")
public class filtroll implements Filter {
       
    public filtroll() {
        super();
    }

	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url = httpServletRequest.getRequestURI();
		
		HttpSession sessao = httpServletRequest.getSession();
		
		if (sessao.getAttribute("usuAutenticado") != null || url.lastIndexOf("login.jsp")>-1 || 
		url.lastIndexOf("autenticador")>-1 ){
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse) response).sendRedirect("login.jsp");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
