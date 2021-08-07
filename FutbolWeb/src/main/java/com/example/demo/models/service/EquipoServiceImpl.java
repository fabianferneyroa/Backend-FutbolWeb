package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.entity.Equipo;
import com.example.demo.repository.EquipoRepository;

@Service
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	private EquipoRepository equipoRepository;
	
	@Override
	public Equipo findById(Integer id) {
		// TODO Auto-generated method stub
		return equipoRepository.getById(id);
	}

	@Override
	public List<Equipo> findAll() {
		// TODO Auto-generated method stub
		return equipoRepository.findAll();
	}

	@Override
	public Equipo save(Equipo equipo) {
		// TODO Auto-generated method stub
		return equipoRepository.save(equipo);
	}

	@Override
	public void deleteById(Integer id) {
		
		equipoRepository.deleteById(id);
		// TODO Auto-generated method stub

	}

}
