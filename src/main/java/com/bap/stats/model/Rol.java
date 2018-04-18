package com.bap.stats.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="roles")
@SequenceGenerator(name="generator_rol", sequenceName="seq_rol",initialValue=1, allocationSize=1)
public class Rol {
	
	@Id
	@Column(name="id_rol")
	@GeneratedValue(generator="generator_rol")
	private Long id;
	
	@Column(nullable=false)
	private String descripcion;
	
	@ManyToMany(mappedBy="roles")
	private List<Usuario> usuarios;

	public Rol(String descripcion, List<Usuario> usuarios) {
		super();
		this.descripcion = descripcion;
		this.usuarios = usuarios;
	}

	public Rol() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
