package br.com.gabriel.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gabriel.acao.interfaces.Action;
import br.com.gabriel.modelo.entidades.UsuarioLogin;
import br.com.gabriel.modelo.infra.Banco;

public class Login implements Action {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		
		String senha = request.getParameter("senha");
		
		UsuarioLogin usuario = Banco.criarBancoDados().existeUsuario(login, senha);
		
		if(usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			
			return "redirect:usuarios?action=listar";	
		}
		
		// Se usuario nao existir
		return "redirect:usuarios?action=loginForm";
	}

}
