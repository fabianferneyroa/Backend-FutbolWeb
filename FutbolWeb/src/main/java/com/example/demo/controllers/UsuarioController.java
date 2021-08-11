package com.example.demo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.models.entity.Usuario;
import com.example.demo.models.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping("/api/Usuario")
@CrossOrigin(origins =  "http://localhost:3000")
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
	
	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario user) {
		
		Integer userID = usuarioService.validarUsuario(user.getUsuario(), user.getContraseña());
		Usuario usuario = usuarioService.findById(userID);
		System.out.print(usuario);
		
		if(userID!=null) {
			String token = getJWTToken(user.getUsuario());
			usuario.setToken(token);
			return usuario;
			
		}
		else {
			return null;
		}
		
		
		
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 6000000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	
	@PostMapping("/login2")
	public String login2() {
		
	String hola = "Hola Mundo";	
		
		return hola;
		
		
	}
	
	@GetMapping("/nombreUsuario/{idUsuario}")
	public String nombreUsuario(@PathVariable Integer idUsuario) {
		
		Usuario userbd = usuarioService.findById(idUsuario);
		
		String usuario = userbd.getUsuario();
		
		return usuario;
	}
	
	

	
}
