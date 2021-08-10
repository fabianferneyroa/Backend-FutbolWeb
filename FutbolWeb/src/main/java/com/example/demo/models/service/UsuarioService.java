package com.example.demo.models.service;

import java.util.List;
import com.example.demo.models.entity.Usuario;

public interface UsuarioService {
	
	public Usuario findById(Integer id);
	
	public List<Usuario> findAllUsers();
	
	public Usuario save(Usuario Users);
	
	public void deleteById(Integer id);
	
	public Integer validarUsuario (String usuario, String contraseña);
	
}
