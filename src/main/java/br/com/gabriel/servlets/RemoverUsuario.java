package br.com.gabriel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/removerUsuario"})
public class RemoverUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		NovoUsuarioServlet.bancoDB.removerUsuario(id);
		
		response.sendRedirect("listarUsuarios");
	}
}
