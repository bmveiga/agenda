package com.bmveiga.projects.AgendaContatos.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bmveiga.projects.AgendaContatos.model.Contato;
import com.bmveiga.projects.AgendaContatos.repositories.ContatoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ContatoRepository contatoRepository;

	public void run(String... args) throws Exception {
		Contato cont1 = new Contato(null, "Maria Silva", "maria@gmail.com", "47989567489");
		Contato cont2 = new Contato(null, "João Pedro", "joao23@hotmail.com", "4896648465");
		Contato cont3 = new Contato(null, "Carla Schaeffer", "carlinha@gmail.com", "4987658464");
		
		contatoRepository.saveAll(Arrays.asList(cont1, cont2, cont3));
	}	
}
