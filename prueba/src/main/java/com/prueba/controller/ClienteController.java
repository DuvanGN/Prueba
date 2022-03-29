package com.prueba.controller;

import com.prueba.model.Tipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.prueba.model.Cliente;
import com.prueba.service.IClienteService;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", consumes = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;

	@PostMapping(value="/cliente/add-new-client", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveNewClient(@RequestBody Cliente clienteToSave) {
		try {			
			return new ResponseEntity<String>(this.clienteService.saveNewCliente(clienteToSave), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String> ("Ocurrió un error al guardar el cliente", HttpStatus.BAD_GATEWAY);
		}
	}

	@GetMapping(value="/cliente/tipos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tipos>> saveNewClient() {
		try {
			return new ResponseEntity<List<Tipos>>(this.clienteService.getTipos(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Tipos>> ((List<Tipos>) null, HttpStatus.BAD_GATEWAY);
		}
	}

}
