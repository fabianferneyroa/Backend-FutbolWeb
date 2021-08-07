package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.entity.Partido;
import com.example.demo.repository.PartidoRepository;

@Service
public class PartidoServiceImpl implements PartidoService {
	
	@Autowired
	private PartidoRepository partidoRepository;

	@Override
	public Partido findById(Integer id) {
		// TODO Auto-generated method stub
		return partidoRepository.getById(id);
	}

	@Override
	public List<Partido> findAllPartidos() {
		// TODO Auto-generated method stub
		return partidoRepository.findAll();
	}

	@Override
	public Partido savePartido(Partido partido) {
		// TODO Auto-generated method stub
		return partidoRepository.save(partido);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		partidoRepository.deleteById(id);

	}

}
