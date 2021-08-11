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
	@OneToOne
	@JoinColumn(name = "id_Usuario")
	private Usuario idUsuario;
	@OneToOne
	@JoinColumn(name = "equipo_Local")
	private Equipo equipoLocal;
	@OneToOne
	@JoinColumn(name = "equipo_Visitante")
	private Equipo equipoVisitante;
	@Column(name = "fecha_Partido")
	private Date fechaPartido;
	@Column(name = "goles_local")
	private Integer golesEquipoLocal;
	@Column(name = "goles_visitante")
	private Integer golesEquipoVisitante;

	public Partido() {
	}

	public Integer getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Integer idPartido) {
		this.idPartido = idPartido;
	}
	
	public void setIdPartido(Equipo equipo) {
		this.equipoLocal = equipo;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
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
