package com.prueba.repository;

import com.prueba.model.Tipos;
import org.springframework.data.repository.CrudRepository;

public interface ITipoRespository  extends CrudRepository<Tipos, Integer>  {
}
