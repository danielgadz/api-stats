package com.bap.stats.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	private String logo;

	@OneToMany(mappedBy = "equipo")
	@JsonIgnore
	private List<Jugador> jugadores;

	public Equipo(String nombre, String logo) {
		super();
		this.nombre = nombre;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

}
