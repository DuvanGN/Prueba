package com.prueba.service;

import java.util.ArrayList;
import java.util.List;

import com.prueba.model.Tipos;
import com.prueba.model.Log;
import com.prueba.repository.ITipoRespository;
import com.prueba.repository.ILogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.model.Cliente;
import com.prueba.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	private IClienteRepository clienteRepo;
	@Autowired
	private ITipoRespository tiposRepo;
	@Autowired
	private ILogRepository logRepo;	

	@Override
	public String saveNewCliente(Cliente cliente) {
		try {
			String mensaje = "Cliente guardado con éxito";
			List<Cliente> clienteExistente = this.clienteRepo.findClienteByTipoDocIdAndNumDoc(cliente.getTipoDocId(), cliente.getNumDoc());
			if (!clienteExistente.isEmpty()) {
				cliente.setIdCliente(clienteExistente.get(0).getIdCliente());
				mensaje = "Cliente actualizado con éxito";
			}
			this.clienteRepo.save(cliente);
			return mensaje;
		} catch (Exception e) {
			return "Ocurrió un error al intentar procesar la transacción de guardado del cliente.";
		}
	}

	@Override
	public List<Tipos> getTipos() {
		List<Tipos> tiposDocumento = new ArrayList<>();
		try {
			this.tiposRepo.findAll().forEach(tipos -> tiposDocumento.add(tipos));  ;
			return tiposDocumento;
		} catch (Exception e) {
			System.out.println("Error: "+e);
			return tiposDocumento;
		}
	}

	@Override
	public String saveLog(Log log) {
		try {
			this.logRepo.save(log);
			return "ok";
		} catch (Exception e) {
			return "Ocurrió un error al registrar el log.";
		}
	}
}
