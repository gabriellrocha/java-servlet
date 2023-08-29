package br.com.gabriel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/listarUsuarios")
public class ListarUsuarios extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("lista", NovoUsuarioServlet.bancoDB.listarUsuarios());
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarUsuarios.jsp");
		dispatcher.forward(request, response);
	}

}
