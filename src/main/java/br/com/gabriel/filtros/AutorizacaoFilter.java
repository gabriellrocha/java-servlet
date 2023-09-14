package br.com.gabriel.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/usuarios", "/criarUsuario"})
public class AutorizacaoFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		String action = servletRequest.getParameter("action");
		
		//cast tipo genérico para tipo mais específico
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		// Recupero a session criada pelo TomCat
		HttpSession session = request.getSession();
		
		// Verifico se o usuario esta logado 
		boolean usuarioNaoLogado = session.getAttribute("usuarioLogado") == null;
		
		boolean eUmaAcaoProtegida = !(action.equals("login") || action.equals("loginForm"));
		
		if(eUmaAcaoProtegida && usuarioNaoLogado) {
			response.sendRedirect("usuarios?action=loginForm");
			return; 
		}
		
		// executa a ação
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
