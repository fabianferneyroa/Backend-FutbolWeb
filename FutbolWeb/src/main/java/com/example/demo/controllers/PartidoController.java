package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Equipo;
import com.example.demo.models.entity.Partido;
import com.example.demo.models.service.EquipoService;
import com.example.demo.models.service.PartidoService;

@RestController
@RequestMapping("/api/Partido")
public class PartidoController {

	@Autowired
	private PartidoService partidoService;
	@Autowired
	private EquipoService equipoService;
	
	@GetMapping("/listar")
	public List<Partido> listarPartidos (){
		
		return partidoService.findAllPartidos();
		
	}
	
	@GetMapping("/{id}")
	public Partido buscarPartidoPorId(Integer id) {
		
		return partidoService.findById(id);
		
	}
	
	@PostMapping
	public Partido registrarPartido(@RequestBody Partido partido) {
		
		return partidoService.savePartido(partido);
		
	}
	
	@PutMapping("/{id}")
	public Partido editarPartido(@RequestBody Partido partido,@PathVariable Integer id) {
		
		Partido partidoBD = partidoService.findById(id);
		
		partidoBD.setIdUsuario(partido.getIdUsuario());
		partidoBD.setEquipoLocal(partido.getEquipoLocal());
		partidoBD.setEquipoVisitante(partido.getEquipoVisitante());
		partidoBD.setFechaPartido(partido.getFechaPartido());
		partidoBD.setGolesEquipoLocal(partido.getGolesEquipoLocal());
		partidoBD.setGolesEquipoVisitante(partido.getGolesEquipoVisitante());
		
		return partidoService.savePartido(partido);
		
	}
	
	@DeleteMapping("/{id}")
	public void eliminarPartido(Integer id) {
		
		partidoService.deleteById(id);
		
	}
	
	@PutMapping("/goles/{id}")
	public Partido editarGoles(@RequestBody Partido partido, @PathVariable Integer id) {
		
		Partido partidoBD = partidoService.findById(id);
		
		partidoBD.setGolesEquipoLocal(partido.getGolesEquipoLocal());
		partidoBD.setGolesEquipoVisitante(partido.getGolesEquipoVisitante());
		
		return partidoService.savePartido(partido);
		
	}
	
	@GetMapping("/nombreEquipoLocal/{id}")
	public String nombreEquipoLocal(Integer id) {
		
		Equipo partidoBD = equipoService.findById(id);
		String nombreEquipoL = partidoBD.getNombreEquipo();
		
		return nombreEquipoL;
		
	}
	
	@GetMapping("/nombreEquipoVisitante/{id}")
	public String nombreEquipoVisitante(Integer id) {
		
		Equipo partidoBD = equipoService.findById(id);
		String nombreEquipoV = partidoBD.getNombreEquipo();
		
		return nombreEquipoV;
		
	}
	
}
