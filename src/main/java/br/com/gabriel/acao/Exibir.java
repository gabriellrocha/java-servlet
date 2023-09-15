package br.com.gabriel.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.acao.interfaces.Action;
import br.com.gabriel.modelo.entidades.Usuario;
import br.com.gabriel.modelo.infra.Banco;

public class Exibir implements Action{
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		Usuario usuario = Banco.criarBancoDados().obterUsuario(id);
		
		request.setAttribute("usuario", usuario);
		
		return "forward:formUpdate.jsp";
	}
}
