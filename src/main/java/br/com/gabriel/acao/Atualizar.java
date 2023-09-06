package br.com.gabriel.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.servlets.ServletApp;

public class Atualizar {
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String dataNascimento = request.getParameter("dataNascimento");
		
		ServletApp.bancoDB.atualizarUsuario(id, nome, dataNascimento);
		
		return "redirect:usuarios?action=listar";
		
		}
}
