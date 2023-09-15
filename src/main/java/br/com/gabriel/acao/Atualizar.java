package br.com.gabriel.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.acao.interfaces.Action;
import br.com.gabriel.modelo.infra.Banco;

public class Atualizar implements Action{
	
	public String executar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String dataNascimento = request.getParameter("dataNascimento");
		
		Banco.criarBancoDados().atualizarUsuario(id, nome, dataNascimento);
				
		return "redirect:usuarios?action=listar";
		
		}
}
