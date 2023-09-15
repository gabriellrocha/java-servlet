package br.com.gabriel.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.acao.interfaces.Action;
import br.com.gabriel.modelo.infra.Banco;

public class Listar implements Action {
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("lista", Banco.criarBancoDados().listarUsuarios());
		
		return "forward:listarUsuarios.jsp";
	}
}
