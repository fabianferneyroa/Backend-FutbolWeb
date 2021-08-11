package com.example.demo.controllers;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Equipo;
import com.example.demo.models.entity.Partido;
import com.example.demo.models.entity.Usuario;
import com.example.demo.models.service.EquipoService;
import com.example.demo.models.service.PartidoService;
import com.example.demo.models.service.UsuarioService;

@RestController
@CrossOrigin(origins="*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping(value="/api/Partido")
public class PartidoController {

	@Autowired
	private PartidoService partidoService;
	@Autowired
	private EquipoService equipoService;
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listar")
	@CrossOrigin
	public List<Partido> listarPartidos (){

		return partidoService.findAllPartidos();
		
	}
	
	@GetMapping("/{id}")
	public Partido buscarPartidoPorId(@PathVariable int id) {
		
		System.out.print(false);
		
		return partidoService.findById(id);
		
	}
	
	@PostMapping(value="/save")
	public Partido registrarPartido(@RequestBody String partido ) throws JSONException, ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Integer userID = usuarioService.obtenerIdUsuario(auth.getName());
		
		JSONObject jsonObject= new JSONObject(partido);
		Partido partido1 = new Partido();
		
		partido1.setIdUsuario(new Usuario(userID));
		partido1.setEquipoLocal(new Equipo(jsonObject.getInt("equipoLocal")));
		partido1.setEquipoVisitante(new Equipo(jsonObject.getInt("equipoVisitante")));
		partido1.setFechaPartido(formatter.parse(jsonObject.getString("fechaPartido")));
		return partidoService.savePartido(partido1);

	}
	
	@PutMapping("/{id}")
	public Partido editarPartido(@RequestBody Partido partido, @PathVariable Integer id) {
		
		Partido partidoBD = partidoService.findById(id);
		
		partidoBD.setIdUsuario(partido.getIdUsuario());
		partidoBD.setEquipoLocal(partido.getEquipoLocal());
		partidoBD.setEquipoVisitante(partido.getEquipoVisitante());
		partidoBD.setFechaPartido(partido.getFechaPartido());
		partidoBD.setGolesEquipoLocal(partido.getGolesEquipoLocal());
		partidoBD.setGolesEquipoVisitante(partido.getGolesEquipoVisitante());
		
		return partidoService.savePartido(partido);
		
	}
	
	@DeleteMapping("/{id}")
	public void eliminarPartido(@PathVariable Integer id) {
		
		partidoService.deleteById(id);
		
	}
	
	@PostMapping("/update")
	public Partido savePartido(@RequestBody String partido) throws JSONException {
		
		JSONObject jsonObject= new JSONObject(partido);
		Partido partido1 = new Partido();
		
		Partido partidoBD = partidoService.findById(jsonObject.getInt("idPartido"));
		
		partidoBD.setGolesEquipoLocal(jsonObject.getInt("golesEquipoLocal"));
		partidoBD.setGolesEquipoVisitante(jsonObject.getInt("golesEquipoVisitante"));
		
		return partidoService.savePartido(partidoBD);
		
	}
	
	@PutMapping("/goles/{id}")
	public Partido editarGoles(@RequestBody Partido partido, @PathVariable Integer id) {
		
		Partido partidoBD = partidoService.findById(id);
		
		partidoBD.setGolesEquipoLocal(partido.getGolesEquipoLocal());
		partidoBD.setGolesEquipoVisitante(partido.getGolesEquipoVisitante());
		
		return partidoService.savePartido(partido);
		
	}
	
	@GetMapping("/nombreEquipoLocal/{id}")
	public String nombreEquipoLocal(Integer id) {
		
		Equipo partidoBD = equipoService.findById(id);
		String nombreEquipoL = partidoBD.getNombreEquipo();
		
		return nombreEquipoL;
		
	}
	
	@GetMapping("/nombreEquipoVisitante/{id}")
	public String nombreEquipoVisitante(Integer id) {
		
		Equipo partidoBD = equipoService.findById(id);
		String nombreEquipoV = partidoBD.getNombreEquipo();
		
		return nombreEquipoV;
		
	}
	
}
