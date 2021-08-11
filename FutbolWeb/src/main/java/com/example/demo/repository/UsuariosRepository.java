package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.entity.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

	@Query("select u.idUsuario from Usuario u  where u.usuario = ?1 and u.contraseña = ?2")
	public Integer validarUsuario (String usuario, String contraseña);
	
	@Query("select u.idUsuario from Usuario u  where u.usuario = ?1")
	public Integer obtenerIdUsuario(String usuario);
}
