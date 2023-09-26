package br.com.gabriel.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.gabriel.modelo.entidades.Usuario;
import br.com.gabriel.modelo.infra.Banco;

@WebServlet("/usuariosJson")
public class UsuarioServiceJSON extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Usuario> list = Banco.criarBancoDados().listarUsuarios();
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);
		
		response.setContentType("application/json");
		response.getWriter().print(jsonString);
	}
}
