package br.com.gabriel.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.entidades.Usuario;


@WebServlet("/listarUsuarios")
public class ListarUsuarios extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("<u>");
		
		for(Usuario u : NovoUsuarioServlet.bancoDB.listarUsuarios()) {
			writer.println("<li>" +u.getNome()+ "</li>");
		}
		
		writer.println("</u>");
		writer.println("</body></html>");
	}

}
