package com.prueba.repository;

import org.springframework.data.repository.CrudRepository;

import com.prueba.model.Log;

public interface ILogRepository extends CrudRepository<Log, Long> {
}
