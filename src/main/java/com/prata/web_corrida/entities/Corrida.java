package com.prata.web_corrida.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Corrida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private Instant DataHora;
	private String nome;
	private String Descricao;
	
	
	
	
	@ManyToMany
	@JoinTable(name = "Corrida_Carro", joinColumns = @JoinColumn(name = "corrida_id"), inverseJoinColumns = @JoinColumn(name = "carro_id"))
	private Set<Carro>  carros = new HashSet<>();
	

	public Set<Carro> getCarros() {
		return carros;
	}

	public Corrida() {
		
	}

	public Corrida(Long id, Instant dataHora, String nome, String descricao) {
		super();
		this.id = id;
		DataHora = dataHora;
		this.nome = nome;
		Descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataHora() {
		return DataHora;
	}

	public void setDataHora(Instant dataHora) {
		DataHora = dataHora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corrida other = (Corrida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}
