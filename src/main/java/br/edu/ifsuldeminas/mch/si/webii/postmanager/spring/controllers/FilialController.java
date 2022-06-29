package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Filial;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.User;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.FilialRepository;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.UserRepository;

@Controller
public class FilialController {
	
	@Autowired
	private FilialRepository filialRepo;
	
	@GetMapping("/filiais")
	public String filiais(Model model) {
		List<Filial> filiais = filialRepo.findAll();
		
		model.addAttribute("filiais", filiais);
		
		return "index2";
	}
	  
	@GetMapping("/filiais/form")
	public String filialForm(@ModelAttribute("filial") 
						   Filial filial) {
		return "filial_form";
	}
	
	@PostMapping("/filiais/new")
	public String filialNew(@ModelAttribute("filial") 
	                      Filial filial) {
		
		filialRepo.save(filial);
		
		return "redirect:/filiais";
	}
	
	@GetMapping("/filiais/{id}")
	public String filialUpdate(@PathVariable("id") 
	                         Integer id, 
	                         Model model) {
		
		Optional<Filial> filialOpt = filialRepo.findById(id);
		
		if (filialOpt.isEmpty())
			throw new IllegalArgumentException("Filial inválida!");
		
		Filial filial = filialOpt.get();
		model.addAttribute("filial", filial);
		
		return "filial_form";
	}
	
	@GetMapping("/filiais/delete/{id}")
	public String filialDelete(@PathVariable("id") 
							 Integer id) {
		
		Optional<Filial> filialOpt = filialRepo.findById(id);
		
		if (filialOpt.isEmpty())
			throw new IllegalArgumentException("Filial inválida!");
		
		Filial filial = filialOpt.get();
		
		filialRepo.delete(filial);
		
		return "redirect:/filiais";
    }

}  