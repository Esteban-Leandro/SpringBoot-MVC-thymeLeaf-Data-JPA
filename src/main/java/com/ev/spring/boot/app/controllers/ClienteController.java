package com.ev.spring.boot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ev.spring.boot.app.models.entity.Cliente;
import com.ev.spring.boot.app.models.services.IClienteService;
import com.ev.spring.boot.app.util.paginator.PageRender;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	
	/* @Qualifier("clienteDaoJPA") en caso de existir 2 
	 iguales se puede especefificar con la anotacion qualifier
	*/
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name = "page", defaultValue = "0") int page ,Model model){
		
		
		Pageable pageRequest = PageRequest.of(page, 5);
		
		Page<Cliente> clientes = clienteService.findAll(pageRequest);
		
		PageRender<Cliente> pageRender = new PageRender<>("/listar", clientes);
		
		model.addAttribute("titulo","Listado de Clientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);
		
		
	
		return "listar";
	}
	 @GetMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		 
		 Cliente cliente = new Cliente();
		 model.put("cliente", cliente);
		 model.put("titulo", "Formulario de cliente");
		 return "form";
	 }
	 
	 @PostMapping(value = "/form")
	 public String guardar(@Valid Cliente cliente, BindingResult result, RedirectAttributes flash , Model model, SessionStatus status) {
		 
		 String mensaje = (cliente.getId() != null)? "Datos Actualizados Exitosamente!":"Datos Guardados Exitosamente!";
		 String mFlash = (cliente.getId() != null) ? "info": "success";
		 if(result.hasErrors()) {
			 model.addAttribute("titulo", "Formulario de Cliente");	
			 return "form";
		 }
		 
		 clienteService.save(cliente);
		 status.setComplete();
		 flash.addFlashAttribute(mFlash, mensaje);
		 return"redirect:listar";
	 }
	 
	 @GetMapping(value = "/form/{id}")
	 public String editar(@PathVariable(value = "id") Long id, RedirectAttributes flasAttributes, Model model) {
		 
		 
		 Cliente cliente = null;
		 if (id > 0) {
			cliente = clienteService.findById(id);
			if (cliente == null) {
				flasAttributes.addFlashAttribute("danger", "No Existen Registros Con El ID Ingresado");
				return "redirect:/listar";
			}
		}else {
			flasAttributes.addFlashAttribute("danger", "El ID No Puede Ser 0");
			return "redirect:/listar";
		}
		 
		 model.addAttribute("cliente", cliente);
		 model.addAttribute("titulo", "Editar Cliente");
		 return "form";
	 }
	 
	 @GetMapping(value = "/eliminar/{id}")
	 public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flasAttributes) {
		 
		clienteService.deleteById(id);
		
		flasAttributes.addFlashAttribute("info", "Datos Eliminados Exitosamente");
		 return "redirect:/listar";
	}
	

}
