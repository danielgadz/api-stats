package com.bap.stats.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "equipos")
@SequenceGenerator(name = "generator_equipo", sequenceName = "seq_equipo", initialValue = 1, allocationSize = 1)
public class Equipo {

	@Id	
	@Column(name = "id_equipo")
	@GeneratedValue(generator = "generator_equipo")	
	private Long id;
		
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
		// TODO Auto-generated constructor stub
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
