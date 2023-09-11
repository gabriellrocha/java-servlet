package br.com.gabriel.acao.interfaces;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
