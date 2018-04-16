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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jugadores")
@SequenceGenerator(name = "generator_jugador", sequenceName = "seq_jugador", initialValue = 1, allocationSize = 1)
public class Jugador implements Serializable {

	private static final long serialVersionUID = -710114180422785946L;
	
	@Id
	@Column(name = "id_jugador")
	@GeneratedValue(generator = "generator_jugador")
	private Long id;
	private String nombre;
	private Integer edad;
	private Double peso;
	private Integer numero;
	private Double estatura;
	private Boolean esCapitan;
	
	@ManyToOne
	@JoinColumn(name="id_equipo")
	@JsonIgnore
	private Equipo equipo;

	public Jugador(String nombre, Integer edad, Double peso, Integer numero, Double estatura, Boolean esCapitan,
			Equipo equipo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.numero = numero;
		this.estatura = estatura;
		this.esCapitan = esCapitan;
		this.equipo = equipo;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
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

}
