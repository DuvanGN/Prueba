package com.prueba.service;

import com.prueba.model.Cliente;
import com.prueba.model.Tipos;
import com.prueba.model.Log;

import java.util.List;

public interface IClienteService {
	
	public String saveNewCliente(Cliente cliente);
	public List<Tipos> getTipos();
	public String saveLog(Log log);
}