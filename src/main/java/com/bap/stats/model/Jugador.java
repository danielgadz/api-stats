package com.bap.stats.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "jugadores")
@SequenceGenerator(name = "generator_jugador", sequenceName = "seq_jugador", initialValue = 1, allocationSize = 1)
public class Jugador implements Serializable {

	private static final long serialVersionUID = -710114180422785946L;
	
	@Id
	@Column(name = "id_jugador")
	@GeneratedValue(generator = "generator_jugador")
	private Long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String correo;
	
	private Integer numero;
	private Boolean esCapitan;
	
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equipo equipo;

	public Jugador(String nombre,String correo, Integer numero, Boolean esCapitan,
			Equipo equipo) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.esCapitan = esCapitan;
		this.equipo = equipo;
		this.correo = correo;
	}

	public Jugador() {
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Boolean getEsCapitan() {
		return esCapitan;
	}

	public void setEsCapitan(Boolean esCapitan) {
		this.esCapitan = esCapitan;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
