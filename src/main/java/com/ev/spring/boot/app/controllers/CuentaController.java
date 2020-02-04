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

import com.ev.spring.boot.app.models.entity.Cuenta;
import com.ev.spring.boot.app.models.services.ICuentaService;

@Controller
@SessionAttributes("cuenta")
public class CuentaController {
	
	@Autowired
	private ICuentaService cuentaService;

	@GetMapping(value = "/listar-cuenta")
	public String listar(Model model) {
		
		model.addAttribute("titulo","Listado de Cuentas");
		model.addAttribute("cuentas", cuentaService.findAll());
		
		return "listar-cuenta";
	}
	
	@GetMapping(value = "/form-cuenta")
	public String crear(Model model) {
		
		Cuenta cuenta = new Cuenta();
		model.addAttribute("titulo", "Formulario de Cuentas");
		model.addAttribute("cuenta", cuenta);
		return "form-cuenta";
	}
	
	@PostMapping(value = "/form-cuenta")
	public String guardar(@Valid Cuenta cuenta, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cuentas");
			return "form-cuenta";
		}
		
		cuentaService.save(cuenta);
		status.setComplete();
		return "redirect:listar-cuenta";
	}
	
	@GetMapping(value = "/form-cuenta/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		
		Cuenta cuenta = null;
		
		if(id > 0) {
			
			cuenta = cuentaService.findById(id);
			
		}else {
			
			return "redirect:/listar-cuenta";
			
		}
		
		model.addAttribute("cuenta", cuenta);
		model.addAttribute("titulo", "Editar Cuenta");
		return "form-cuenta";
	}
	
	@GetMapping(value = "/eliminar-cuenta/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		
		cuentaService.deleteById(id);
		return "redirect:/listar-cuenta";
	}
}
