package com.bap.stats.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "equipos")
@SequenceGenerator(name = "generator_equipo", sequenceName = "seq_equipo", initialValue = 1, allocationSize = 1)
public class Equipo implements Serializable {

	private static final long serialVersionUID = 7312208578639034663L;

	@Id
	@Column(name = "id_equipo")
	@GeneratedValue(generator = "generator_equipo")
	private Long id;

	@Column(nullable = false)
	private String nombre;

	private String capitan;
	private String logo;

	public Equipo(String nombre, String capitan, String logo) {
		super();
		this.nombre = nombre;
		this.capitan = capitan;
		this.logo = logo;
	}

	public Equipo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCapitan() {
		return capitan;
	}

	public void setCapitan(String capitan) {
		this.capitan = capitan;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
