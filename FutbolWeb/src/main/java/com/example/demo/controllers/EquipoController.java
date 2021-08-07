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
import com.example.demo.models.service.EquipoService;



@RestController
@RequestMapping("/api/Equipo")
public class EquipoController {
	
	@Autowired
	private EquipoService equipoService;
	
	@GetMapping("/listar")
	public List<Equipo> listar(){
		
		return equipoService.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Equipo buscarPorId(@PathVariable Integer id) {
		
		return equipoService.findById(id);
		
	}
	
	@PostMapping
	public Equipo registrar(@RequestBody Equipo equipo) {
		
		return equipoService.save(equipo);
		
	}
	
	@PutMapping("/{id}")
	public Equipo editar(@RequestBody Equipo equipo, @PathVariable Integer id) {
		
		Equipo equipoDB = equipoService.findById(id);
		
		equipoDB.setNombreEquipo(equipo.getNombreEquipo());
		
		return equipoService.save(equipoDB);
		
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		
		equipoService.deleteById(id);
		
	}

}
