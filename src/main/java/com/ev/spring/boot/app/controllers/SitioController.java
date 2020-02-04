package com.ev.spring.boot.app.controllers;

import java.util.Map;

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

import com.ev.spring.boot.app.models.entity.Sitio;
import com.ev.spring.boot.app.models.services.ISitioService;

@Controller
@SessionAttributes("sitio")
public class SitioController {
	
	@Autowired
	private ISitioService sitioService;
	
	@GetMapping(value = "/listar-sitio")
	public String listar (Map<String, Object> model) {
		
		model.put("titulo", "Listado de Sitios");
		model.put("sitios", sitioService.findAll());
		return "listar-sitio";
	} 
	
	@GetMapping(value = "/form-sitio")
	public String crear(Map<String, Object> model) {
		
		Sitio sitio = new Sitio();
		model.put("titulo", "Formulario de Sitios");
		model.put("sitio", sitio);
		
		return "form-sitio";
	}
	
	@PostMapping(value = "/form-sitio")
	public String guardar(@Valid Sitio sitio, BindingResult result,Map<String, Object>model, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.put("titulo", "Formulario de sitios");
			return "form-sitio";
		}
		
		sitioService.save(sitio);
		status.setComplete();
		return "redirect:listar-sitio";
	}
	
	@GetMapping(value = "/form-sitio/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		
		Sitio sitio = null;
		
		if (id > 0) {
			
			sitio = sitioService.findById(id);
		}else {
			
			return "redirect:/listar-sitio";
		}
		model.addAttribute("sitio", sitio);
		model.addAttribute("titulo", "Editar sitio");
		
		return "form-sitio";
	}
	
	@GetMapping(value = "/eliminar-sitio/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		
		sitioService.deleteById(id);
		return "listar-sitio";
	}
	
}
