package br.com.gabriel.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gabriel.acao.interfaces.Action;

public class Logout implements Action {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		//session.removeAttribute("usuarioLogado");
		
		session.invalidate(); 
		
		return "redirect:usuarios?action=loginForm";
	}

}
