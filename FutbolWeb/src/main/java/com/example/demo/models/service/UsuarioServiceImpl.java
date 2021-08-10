package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.entity.Usuario;
import com.example.demo.repository.UsuariosRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuariosRepository usuarioRepository;
	
	@Override
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return usuarioRepository.getById(id);
	}

	@Override
	public List<Usuario> findAllUsers() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario save(Usuario users) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(users);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);

	}

	@Override
	public Integer validarUsuario(String usuario, String contraseña) {
		
		return usuarioRepository.validarUsuario(usuario, contraseña);
		
	}

}
