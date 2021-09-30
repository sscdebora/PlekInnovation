/*
 * Model Usuario / Criação 02/08/2021
 * Todos os direitos reservados Acsses Local
 *
 * Version Beta 1.0
 * 
 * @autor Felipe Augusto
 * @autor Gabriel Conceição
 * @autora Regina Rodrigues
 * @autora Debora Cristina
 * @Mathues Moreira
 */

package com.plek.pessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
public class Usuario {

	/**
	 * Numero de id gerado automaticamente
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@NotBlank
	@Size(min = 5, max = 1000)
	private String nomeCompleto;

	@Email
	@NotNull
	@NotBlank
	@Size(min = 5, max = 1000)
	private String emailUsuario;

	@NotNull
	@NotBlank
	@Size(min = 5, max = 1000)
	private String senhaUsuario;
	
	private String foto;
	
	private String tipo;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Post> postagem;

		
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	

	public List<Post> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Post> postagem) {
		this.postagem = postagem;
	}

	public long getIdUsuario() {
		return id;
	}

	

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

}
