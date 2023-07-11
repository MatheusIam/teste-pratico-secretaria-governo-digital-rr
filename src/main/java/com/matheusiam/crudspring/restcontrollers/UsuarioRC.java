package com.matheusiam.crudspring.restcontrollers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusiam.crudspring.entities.Usuario;
import com.matheusiam.crudspring.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRC {
	@Autowired
	private UsuarioService service;
	
	// achar todos
	@GetMapping
	public ResponseEntity<List<Usuario>> acheTodos(){
		List<Usuario> usuarios = service.acheTodos();
		return ResponseEntity.ok().body(usuarios); 
		// Devolve um JSON com todos os usuários da base de dados
	}
	
	// Ache por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> achePorId(@PathVariable Integer id){
		Usuario obj = service.achePorId(id);
		return ResponseEntity.ok().body(obj); // Devolve um JSON com o usuário
	}
	
	// Salvar um usuario no banco de dados
	@PostMapping
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario obj){
		obj = service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // 
		return ResponseEntity.created(uri).body(obj);
	}
	
	// Deletar um usuário no banco de dados
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Usuario> deletar (@PathVariable Integer id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	// Atualizar um usuário existente no banco de dados
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Integer id, @RequestBody Usuario obj){
		service.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
