package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Equipo")
	private Integer idEqupo;
	@Column(name = "nombre_Equipo")
	private String nombreEquipo;

	public Equipo() {
	}

	public Equipo(Integer idEqupo, String nombreEquipo) {
		this.idEqupo = idEqupo;
		this.nombreEquipo = nombreEquipo;
	}

	public Integer getIdEqupo() {
		return idEqupo;
	}

	public void setIdEqupo(Integer idEqupo) {
		this.idEqupo = idEqupo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
