package br.com.gabriel.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Usuario {
	
	private Long id;
	private String nome;
	private String senha;
	private String dataNascimento;
	
	public Usuario() {
	}

	public Usuario(Long id, String nome, String senha, String dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		setDataNascimento(dataNascimento);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String toString() {
		return this.nome;
	}
	
	public String getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(String data) {
		
//		 * Método sem tratamento de Exceção adequado, pois o foco deste projeto é aprender
//		 * sobre JSP*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			sdf.parse(data);
			this.dataNascimento = data;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	}
}
