package br.com.gabriel.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/usuarios", "/criarUsuario"})
public class MonitoramentoFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chair) throws IOException, ServletException {
		
		String action = request.getParameter("action");
		
		long millisBefore = System.currentTimeMillis();
		
		chair.doFilter(request, response);
		
		long millisAfter = System.currentTimeMillis();
		
		System.out.println("Tempo de execução da acão " + action + ":" + (millisAfter - millisBefore));
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
}
