package br.com.gabriel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.entidades.Usuario;

@WebServlet({"/mostrarUsuario", "/atualizarUsuario"})
public class AtualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Usuario usuario = NovoUsuarioServlet.bancoDB.obterUsuario(id);
		
		if(usuario != null) {	
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("formUpdate.jsp");
			
			request.setAttribute("usuario", usuario);
			
			dispatcher.forward(request, response);	
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String dataNascimento = req.getParameter("dataNascimento");
		
		NovoUsuarioServlet.bancoDB.atualizarUsuario(id, nome, dataNascimento);
		
		resp.sendRedirect("listarUsuarios");
	}

}
