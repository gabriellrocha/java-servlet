package br.com.gabriel.infra;

import java.util.ArrayList;
import java.util.List;

import br.com.gabriel.entidades.Usuario;

public class Banco {
	
	// Simulação de um banco de dados
	
	private Banco() {}
	
	private static Banco instance = null; 
	
	// Singleton
	
	public static Banco criarBancoDados() {
		if (instance == null) {
			instance = new Banco();
		}
		
		return instance;
	}
	
	private static List<Usuario> lista = new ArrayList<>();
	
	public void cadastrarUsuario(Usuario usuario) {
		lista.add(usuario);
	}
	
	public boolean removerUsuario(Long id) {
		int pos = 0;
		for(Usuario u : lista) {
			if(u.getId() == id) {
				lista.remove(pos);
				return true;
			}
			pos++;
		}
		return false;
	}
	
	public List<Usuario> listarUsuarios(){
		return lista;
	}
}
