package com.bmveiga.projects.AgendaContatos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmveiga.projects.AgendaContatos.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
	

}
