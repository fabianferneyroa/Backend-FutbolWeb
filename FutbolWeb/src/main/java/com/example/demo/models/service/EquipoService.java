package com.example.demo.models.service;

import java.util.List;
import com.example.demo.models.entity.Equipo;

public interface EquipoService {

	public Equipo findById(Integer id);

	public List<Equipo> findAll();

	public Equipo save(Equipo equipo);

	public void deleteById(Integer id);

}
