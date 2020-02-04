package com.ev.spring.boot.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ev.spring.boot.app.models.entity.Medidor;
import com.ev.spring.boot.app.models.services.IMedidorService;

@Controller
@SessionAttributes("medidor")
public class MedidorController {

	@Autowired
	private IMedidorService medidorService;
	
	@GetMapping(value = "/listar-medidor")
	public String listar(Model model) {
		
		model.addAttribute("medidores", medidorService.findAll());
		model.addAttribute("titulo", "Listado de medidores");
		
		return "listar-medidor";
	}
	
	@GetMapping(value = "/form-medidor")
	public String crear (Model model) {
		
		Medidor medidor = new Medidor();
		
		model.addAttribute("medidor", medidor);
		model.addAttribute("titulo", "Formulario de Medidor");
		
		return "form-medidor";
	}
	
	@PostMapping(value = "/form-medidor")
	public String guardar(@Valid Medidor medidor, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario de Medidor");
			return "form-medidor";
		}
		medidorService.save(medidor);
		status.setComplete();
		return "redirect:/listar-medidor";
	}
	
	@GetMapping(value = "/form-medidor/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		
		Medidor medidor = null;
		if (id > 0) {
			medidor = medidorService.findById(id);
		}else {
			return "redirect:/listar-medidor";
		}
		
		model.addAttribute("medidor", medidor);
		model.addAttribute("titulo", "Editar Medidor");
		
		return "form-medidor";
	}
	
	@GetMapping(value = "/eliminar-medidor/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		
		medidorService.deleteById(id);
		return "listar-medidor";
	}
}
