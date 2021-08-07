package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Partido;

public interface PartidoService  {
	
	public Partido findById(Integer id);
	
	public List<Partido> findAllPartidos();
	
	public Partido savePartido(Partido partido);
	
	public void deleteById(Integer id);
	
}
