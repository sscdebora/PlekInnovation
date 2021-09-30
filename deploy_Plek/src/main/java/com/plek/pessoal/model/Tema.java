/*
 * Model Tema / Criação 02/08/2021
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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "tema")
public class Tema {

	/**
	 * Numero de idTema gerado automaticamente
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTema;

	
	private String tipoUsuario;

	@Size(min = 2, max = 90)
	private String tipoDeficiencia;

	@Size(min = 1, max = 100000)
	private String experienciaUsuario;

	/**
	 * Realiza uma relação Um para muitos com a tabela Post
	 * 
	 */
	
	
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<Post> postagem;

	

	public List<Post> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Post> postagem) {
		this.postagem = postagem;
	}

	public long getIdTema() {
		return idTema;
	}

	public void setIdTema(long idTema) {
		this.idTema = idTema;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getTipoDeficiencia() {
		return tipoDeficiencia;
	}

	public void setTipoDeficiencia(String tipoDeficiencia) {
		this.tipoDeficiencia = tipoDeficiencia;
	}

	public String getExperienciaUsuario() {
		return experienciaUsuario;
	}

	public void setExperienciaUsuario(String experienciaUsuario) {
		this.experienciaUsuario = experienciaUsuario;
	}

}
