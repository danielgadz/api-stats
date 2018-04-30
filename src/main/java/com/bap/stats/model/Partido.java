package com.bap.stats.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "partidos")
@SequenceGenerator(name = "generator_partido", sequenceName = "seq_partido", initialValue = 1, allocationSize = 1)
public class Partido implements Serializable {

	private static final long serialVersionUID = -8187403362972706028L;

	@Id
	@Column(name = "id_partido")
	@GeneratedValue(generator = "generator_partido")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_equipo_local")
	@JsonIgnoreProperties({"logo" })
	private Equipo equipo_local;

	@ManyToOne
	@JoinColumn(name = "id_equipo_visita")
	@JsonIgnoreProperties({ "logo" })
	private Equipo equipo_visita;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "id_jornada")
	 * 
	 * private Jornada jornada;
	 */

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "id_estatus")
	 * 
	 * private Estatus estatus;
	 */

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fecha;

	@Column(nullable = false)
	private String hora;

	@Column(nullable = false)
	private String lugar;

	public Partido() {
		super();
	}

	public Partido(Equipo equipo_local, Equipo equipo_visita, Date fecha, String hora, String lugar) {
		super();
		this.equipo_local = equipo_local;
		this.equipo_visita = equipo_visita;
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipo getEquipo_local() {
		return equipo_local;
	}

	public void setEquipo_local(Equipo equipo_local) {
		this.equipo_local = equipo_local;
	}

	public Equipo getEquipo_visita() {
		return equipo_visita;
	}

	public void setEquipo_visita(Equipo equipo_visita) {
		this.equipo_visita = equipo_visita;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

}
