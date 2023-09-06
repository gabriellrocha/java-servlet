package br.com.gabriel.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.modelo.entidades.Usuario;
import br.com.gabriel.servlets.ServletApp;

public class Criar {
	
	public void executar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String nome = request.getParameter("nome");
		String data = request.getParameter("dataNascimento");
		Usuario newUsuario = new Usuario(null, nome, null, data); 
		
		ServletApp.bancoDB.cadastrarUsuario(newUsuario);
		response.sendRedirect("usuarios?action=listar");
		
	}
}
