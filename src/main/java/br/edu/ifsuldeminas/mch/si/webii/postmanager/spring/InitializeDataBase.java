package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Filial;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.User;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.FilialRepository;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.UserRepository;

@Component
public class InitializeDataBase implements CommandLineRunner{
	
	@Autowired
	private FilialRepository uRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Filial emerson = new Filial();
		emerson.setName("Emerson Assis");
		emerson.setEmail("assis@gmail.com");
		emerson.setAddress("ruajoao");		
		emerson.setPhone("6525215");
		
		Filial luiza = new Filial();
		luiza.setName("Luiza Carvalho");
		luiza.setEmail("lu@mail.com");
		luiza.setAddress("ruajoaquin");
		luiza.setPhone("625563263");
		
		uRepo.save(emerson);
		uRepo.save(luiza);
	}
}
