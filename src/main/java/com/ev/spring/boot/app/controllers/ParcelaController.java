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

import com.ev.spring.boot.app.models.entity.Parcela;
import com.ev.spring.boot.app.models.services.IParcelaService;

@Controller
@SessionAttributes("parcela")
public class ParcelaController {

	@Autowired
	private IParcelaService parcelaService;
	
	@GetMapping(value = "/listar-parcela")
	public String listar(Model model){
		model.addAttribute("titulo","Listado de Parcelas");
		model.addAttribute("parcelas", parcelaService.findAll());
		return "listar-parcela";
	}
	
	@GetMapping(value = "/form-parcela")
	public String crear(Map<String, Object> model) {
		 
		 Parcela parcela = new Parcela();
		 model.put("parcela", parcela);
		 model.put("titulo", "Formulario de Parcela");
		 return "form-parcela";
	 }
	
	@PostMapping(value = "/form-parcela")
	 public String guardar(@Valid Parcela parcela, BindingResult result, Model model, SessionStatus status) {
		 
		 
		 if(result.hasErrors()) {
			 model.addAttribute("titulo", "Formulario de Parcela");	
			 return "form-parcela";
		 }
		 
		 parcelaService.save(parcela);
		 status.setComplete();
		 return"redirect:listar-parcela";
	 }
	
	@GetMapping(value = "/form-parcela/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		
		Parcela parcela = null;
		if (id > 0) {
			
			parcela = parcelaService.findById(id);
			
		}else {
			
			return "redirect:/listar-parcela";
			
		}
		
		model.addAttribute("parcela", parcela);
		model.addAttribute("titulo", "Editar parcela");
		return "forn-parcela";
	}
	
	@GetMapping(value = "/eliminar-parcela/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		
		parcelaService.deleteById(id);
		return "listar-parcela";
	}
	
}
