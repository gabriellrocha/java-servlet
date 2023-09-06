package br.com.gabriel.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.modelo.entidades.Usuario;
import br.com.gabriel.servlets.ServletApp;

public class Exibir {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		Usuario usuario = ServletApp.bancoDB.obterUsuario(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("formUpdate.jsp");
		
		request.setAttribute("usuario", usuario);
		dispatcher.forward(request, response);
	}
}
