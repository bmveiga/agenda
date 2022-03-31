package com.bmveiga.projects.AgendaContatos.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.bmveiga.projects.AgendaContatos.model.Contato;
import com.bmveiga.projects.AgendaContatos.service.ContatoService;

@RestController
@RequestMapping(value = "/contatos")
public class ContatosControler {

	@Autowired
	private ContatoService service;
	
	@GetMapping
	public ResponseEntity<List<Contato>> findAll(){
		List<Contato> todosContatos = service.findAll();
		return ResponseEntity.ok().body(todosContatos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contato> findById(@PathVariable Long id){
		Contato obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Contato> insert(@RequestBody Contato obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/pesquisar/{dado}")
	public ResponseEntity<List<Contato>> findByNome(@PathVariable String dado){
		List<Contato> objNome = service.findByName(dado);
		List<Contato> objTelefone = service.findByPhone(dado);
		List<Contato> objEmail = service.findByEmail(dado);
		List<Contato> obj = new ArrayList<>();
		obj.addAll(objNome);
		obj.addAll(objTelefone);
		obj.addAll(objEmail);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/pesquisartelefone/{nome}")
	public ResponseEntity<List<Contato>> findByPhone(@PathVariable String telefone){
		List<Contato> obj = service.findByPhone(telefone);
		return ResponseEntity.ok().body(obj);
	}
}
