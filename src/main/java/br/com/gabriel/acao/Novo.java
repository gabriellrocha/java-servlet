package br.com.gabriel.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.acao.interfaces.Action;

public class Novo implements Action {
	
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		return "forward:form.jsp";
	}
}
