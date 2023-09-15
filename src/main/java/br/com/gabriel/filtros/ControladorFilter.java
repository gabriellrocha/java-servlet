package br.com.gabriel.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.acao.interfaces.Action;

//@WebFilter(urlPatterns = "/usuarios")
public class ControladorFilter implements Filter {

	public void destroy() {
		
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
				
		String action = servletRequest.getParameter("action");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String pathJSP = null;
		
		// nome qualificado da classe
		String nomeClasse = "br.com.gabriel.acao." + action.substring(0, 1).toUpperCase() + action.substring(1);
		
		
		// Decide qual acão executar
		try {
			// carrega a classe em memoria
			Class classe = Class.forName(nomeClasse);
			
			// objeto responsavel por chamar o executar correspondente
			Action obj = (Action) classe.newInstance();
			
			pathJSP = obj.executar(request, response);	
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] forwarOrRedirect = pathJSP.split(":");
		
		/* Se o prefixo for "forward" dispacha para o jsp
		 * Se for "redirect" o cliente (navegador) faz um redirecionamento pro endereço informado
		 * */
		
		if(forwarOrRedirect[0].equals("forward")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/" + forwarOrRedirect[1]);
			dispatcher.forward(request, response);
			
		} else { 
			response.sendRedirect(forwarOrRedirect[1]);
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
