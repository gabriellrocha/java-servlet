package br.com.gabriel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.acao.Atualizar;
import br.com.gabriel.acao.Criar;
import br.com.gabriel.acao.Excluir;
import br.com.gabriel.acao.Exibir;
import br.com.gabriel.acao.Listar;
import br.com.gabriel.modelo.infra.Banco;

@WebServlet(urlPatterns = {"/usuarios"})
public class ServletApp extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static final Banco bancoDB = Banco.criarBancoDados();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("criar")) {
			
			Criar obj = new Criar();
			obj.executar(request, response);
			
			
		} else if (action.equals("listar")) {	
			
			Listar obj = new Listar();
			request.setAttribute("lista", bancoDB.listarUsuarios());
			obj.executa(request, response);
			
		} else if (action.equals("excluir")) {
			
			Excluir obj = new Excluir();
			obj.executar(request, response);
			
		} else if (action.equals("exibir")) {
			
			Exibir obj = new Exibir();
			obj.executa(request, response);
			
		} else if (action.equals("atualizar")) {
			
			Atualizar obj = new Atualizar();
			obj.executar(request, response);
			
		}
	}	
}
