package com.bmveiga.projects.AgendaContatos.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmveiga.projects.AgendaContatos.model.Contato;
import com.bmveiga.projects.AgendaContatos.repositories.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;
	
	public List<Contato> findAll(){
		return repository.findAll();
	}
	
	public Contato findById(Long id) {
		Optional<Contato> obj = repository.findById(id);
		return obj.get();	
	}
	
	public Contato insert(Contato obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Contato update(Long id, Contato obj) {
		Contato entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Contato entity, Contato obj) {
		entity.setEmail(obj.getEmail());
		entity.setNome(obj.getNome());
		entity.setTelefone(obj.getTelefone());
	}
	
	public List<Contato> findByName(String nome) {
		List<Contato> todosContatos = repository.findAll();
		List<Contato> filtrado = todosContatos.stream().filter(x -> x.getNome().contains(nome)).collect(Collectors.toList());
		return filtrado;	
	}
	
	public List<Contato> findByPhone(String telefone) {
		List<Contato> todosContatos = repository.findAll();
		List<Contato> filtrado = todosContatos.stream().filter(x -> x.getTelefone().contains(telefone)).collect(Collectors.toList());
		return filtrado;	
	}

	public List<Contato> findByEmail(String dado) {
		List<Contato> todosContatos = repository.findAll();
		List<Contato> filtrado = todosContatos.stream().filter(x -> x.getEmail().contains(dado)).collect(Collectors.toList());
		return filtrado;
	}
}
