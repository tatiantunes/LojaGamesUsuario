package com.lojagamesUsuario.LojaGamesUsuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojagamesUsuario.LojaGamesUsuario.model.Usuario;
import com.lojagamesUsuario.LojaGamesUsuario.repository.UsuarioRepository;



@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	public UsuarioRepository repository;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/usuario/{usuario}")
	public ResponseEntity<List<Usuario>> findByName(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuarios) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuarios));
	}

	@PutMapping
	public ResponseEntity<Usuario> put(@RequestBody Usuario usuarios) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuarios));
	}

	@DeleteMapping("/{id}")
	public void delete(long id) {
		repository.deleteById(id);
	}
}