package com.bap.stats.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@SequenceGenerator(name = "generator_usuario", sequenceName = "seq_usuario", initialValue = 1, allocationSize = 1)
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(generator = "generator_usuario")
	private Long id;

	@Column(nullable = false)
	private String correo;

	@Column(nullable = false)
	private String clave;

	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(	name = "usuarios_roles", 
				joinColumns = { @JoinColumn(name = "id_usuario") },
				inverseJoinColumns = { @JoinColumn(name = "id_rol") })
	private List<Rol> roles;

	public Usuario(String correo, String clave, List<Rol> roles) {
		super();
		this.correo = correo;
		this.clave = clave;
		this.roles = roles;
	}

	public Usuario() {
		super();
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
