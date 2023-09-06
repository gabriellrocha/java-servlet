package br.com.gabriel.modelo.infra;

import java.util.ArrayList;
import java.util.List;

import br.com.gabriel.modelo.entidades.Usuario;

public class Banco {
	
	// Simulação de um banco de dados
	
	private Banco() {}
	
	private Long idUser = 1L;
	
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
		usuario.setId(incrementarId());
		lista.add(usuario);
	}
	
	public Usuario obterUsuario(Long id) {
		for (Usuario u : lista) {
			if(u.getId() == id ) {
				return u;
			}	
		}
		return null;
	}
	
	public void atualizarUsuario(Long id, String nome, String dataNascimento) {
		Usuario usuario = obterUsuario(id);
		usuario.setNome(nome);
		usuario.setDataNascimento(dataNascimento);
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
	
	private long incrementarId() {
		return idUser ++;
	}
}
