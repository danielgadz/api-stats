package com.bap.stats.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "resultados")
@SequenceGenerator(name = "generator_resultado", sequenceName = "seq_resultado", initialValue = 1, allocationSize = 1)
public class Resultado implements Serializable {

	private static final long serialVersionUID = 5735210074731089712L;

	@Id
	@Column(name = "id_resultado")
	@GeneratedValue(generator = "generator_resultado")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_equipo")
	@JsonIgnoreProperties({ "logo" })
	private Equipo equipo;

	@OneToOne
	@JoinColumn(name = "id_partido")
	private Partido partido;

	@Column(nullable = false)
	private Integer set;

	@Column(nullable = false)
	private Integer marcador;

	@Column(nullable = false)
	private Boolean triunfo;

	public Resultado() {
		super();
	}

	public Resultado(Equipo equipo, Partido partido, Integer set, Integer marcador, Boolean triunfo) {
		super();
		this.equipo = equipo;
		this.partido = partido;
		this.set = set;
		this.marcador = marcador;
		this.triunfo = triunfo;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Integer getSet() {
		return set;
	}

	public void setSet(Integer set) {
		this.set = set;
	}

	public Integer getMarcador() {
		return marcador;
	}

	public void setMarcador(Integer marcador) {
		this.marcador = marcador;
	}

	public Boolean getTriunfo() {
		return triunfo;
	}

	public void setTriunfo(Boolean triunfo) {
		this.triunfo = triunfo;
	}

}
