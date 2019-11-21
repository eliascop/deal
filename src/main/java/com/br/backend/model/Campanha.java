package com.br.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "campanha", schema = "deal")
public class Campanha implements Serializable{
		
	private static final long serialVersionUID = 1L;
				
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("codigo")
	private int codigo;
	
	@JsonProperty("nome")
	private String nome;

	@JsonProperty("dataInicial")
	private Date dataInicial;

	@JsonProperty("dataFinal")
	private Date dataFinal;
	
	@JsonProperty("createdAt")
	private Date createdAt;	
	
	@JsonProperty("updatedAt")
	private Date updatedAt;	

	public Campanha() {
	}

	public Campanha(int codigo, String nome, Date dataInicial, Date dataFinal, Date updatedAt) {
		this.codigo = codigo;
		this.nome = nome;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.updatedAt = updatedAt;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Campanha [codigo=" + codigo + ", nome=" + nome + ", dataInicial=" + dataInicial + ", dataFinal="
				+ dataFinal + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Campanha))
			return false;
		Campanha other = (Campanha) obj;
		return codigo == other.codigo;
	}
	
	
	
}
