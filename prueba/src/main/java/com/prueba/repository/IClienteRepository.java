package com.prueba.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.prueba.model.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {
	
	List<Cliente> findClienteByTipoDocIdAndNumDoc(Long docId, Long numDoc);
	
}