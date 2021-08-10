package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Usuario;
import com.example.demo.models.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/Usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public List<Usuario> listarUsuarios(){
		
		return usuarioService.findAllUsers();
		
	}
	
	@GetMapping("/{id}")
	public Usuario buscarUsurioPorId(Integer id) {
		
		return usuarioService.findById(id);
		
	}
	
	
	@PostMapping("/auth/register")
	public Usuario registrarUsuario(@RequestBody Usuario users) {
		
		return usuarioService.save(users);
		
	}
	
	@PutMapping("/{id}")
	public Usuario editarUsuario(@RequestBody Usuario users, @PathVariable Integer id) {
		
		Usuario usuarioBd = usuarioService.findById(id);
		
		usuarioBd.setNombreUsuario(users.getNombreUsuario());
		usuarioBd.setCorreoUsuario(users.getCorreoUsuario());
		usuarioBd.setUsuario(users.getUsuario());
		usuarioBd.setContraseña(users.getContraseña());
		
		return usuarioService.save(users);
		
	}
	
	@DeleteMapping("/{id}")
	public void eliminarUsuario(Integer id) {
		
		usuarioService.deleteById(id);
		
	}
	
	@GetMapping("/validarUsuario/{usuario}/{contraseña}")
	public Integer validarUsuario(@PathVariable String usuario, @PathVariable String contraseña) {
	
		
		return usuarioService.validarUsuario(usuario, contraseña);
		
	}
	
}
