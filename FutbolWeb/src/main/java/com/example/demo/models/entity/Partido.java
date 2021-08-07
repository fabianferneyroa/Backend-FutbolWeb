package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "partidos")
public class Partido  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Partido")
	private Integer idPartido;
	@Column(name = "id_Usuario")
	private Integer idUsuario;
	@Column(name = "equipo_Local")
	private Integer equipoLocal;
	@Column(name = "equipo_Visitante")
	private Integer equipoVisitante;
	@Column(name = "fecha_Partido")
	private Date fechaPartido;
	@Column(name = "goles_local")
	private Integer golesEquipoLocal;
	@Column(name = "goles_visitante")
	private Integer golesEquipoVisitante;

	public Partido() {
	}

	public Partido(Integer idPartido, Integer idUsuario, Integer equipoLocal, Integer equipoVisitante, Date fechaPartido,
			Integer golesEquipoLocal, Integer golesEquipoVisitante) {
		this.idPartido = idPartido;
		this.idUsuario = idUsuario;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fechaPartido = fechaPartido;
		this.golesEquipoLocal = golesEquipoLocal;
		this.golesEquipoVisitante = golesEquipoVisitante;
	}

	public Integer getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Integer idPartido) {
		this.idPartido = idPartido;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Integer equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Integer getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Integer equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public Date getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(Date fechaPartido) {
		this.fechaPartido = fechaPartido;
	}

	public Integer getGolesEquipoLocal() {
		return golesEquipoLocal;
	}

	public void setGolesEquipoLocal(Integer golesEquipoLocal) {
		this.golesEquipoLocal = golesEquipoLocal;
	}

	public Integer getGolesEquipoVisitante() {
		return golesEquipoVisitante;
	}

	public void setGolesEquipoVisitante(Integer golesEquipoVisitante) {
		this.golesEquipoVisitante = golesEquipoVisitante;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
