package br.com.gabriel.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.servlets.ServletApp;

public class Excluir {
	
	public void executar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		ServletApp.bancoDB.removerUsuario(id);
		response.sendRedirect("usuarios?action=listar");
		
	}
}
