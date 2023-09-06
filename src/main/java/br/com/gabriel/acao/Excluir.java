package br.com.gabriel.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.servlets.ServletApp;

public class Excluir {
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		ServletApp.bancoDB.removerUsuario(id);
		
		return "redirect:usuarios?action=listar";		
	}
}
